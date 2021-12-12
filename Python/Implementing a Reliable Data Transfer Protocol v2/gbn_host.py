from network_simulator import NetworkSimulator, Packet, EventEntity
from enum import Enum
from struct import pack, unpack

class GBNHost():

    # The __init__ method accepts:
    # - a reference to the simulator object
    # - the value for this entity (EntityType.A or EntityType.B)
    # - the interval for this entity's timer
    # - the size of the window used for the Go-Back-N algorithm
    def __init__(self, simulator, entity, timer_interval, window_size):
        
        # These are important state values that you will need to use in your code
        self.simulator = simulator
        self.entity = entity
        
        # Sender properties
        self.timer_interval = timer_interval        # The duration the timer lasts before triggering
        self.window_size = window_size              # The size of the seq/ack window
        self.window_base = 0                        # The last ACKed packet. This starts at 0 because no packets 
        self.next_seq_num = 0                       # have been ACKed.                   
                                                    # The SEQ number that will be used next
        self.unACKed_buffer= []
        self.app_layer_buffer= []

        # Reciever Properties
        self.expected_seq_num= 0
        self.last_ACK= self.create_pkt(-1, "ACK")

    ###########################################################################################################
    ## Core Interface functions that are called by Simulator

    # This function implements the SENDING functionality. It should implement retransmit-on-timeout. 
    # Refer to the GBN sender flowchart for details about how this function should be implemented
    def receive_from_application_layer(self, payload):
        if self.next_seq_num < self.window_base + self.window_size:
            self.unACKed_buffer.append(self.create_pkt(self.next_seq_num,payload))
            self.simulator.pass_to_network_layer(self.entity, self.unACKed_buffer[self.next_seq_num], self.is_ack(self.unACKed_buffer[self.next_seq_num]))
            if self.window_base == self.next_seq_num:
                self.simulator.start_timer(self.entity, self.timer_interval)
            self.next_seq_num += 1

        else: 
            self.app_layer_buffer.append(payload)


    # This function implements the RECEIVING functionality. This function will be more complex that
    # receive_from_application_layer(), it includes functionality from both the GBN Sender and GBN receiver
    # FSM's (both of these have events that trigger on receive_from_network_layer). You will need to handle 
    # data differently depending on if it is a packet containing data, or if it is an ACK.
    # Refer to the GBN receiver flowchart for details about how to implement responding to data pkts, and
    # refer to the GBN sender flowchart for details about how to implement responidng to ACKs
    def receive_from_network_layer(self, byte_data):
        if (self.is_ack(byte_data)) and (not self.is_corrupt(byte_data)):
            ackNUM = self.get_ACK(byte_data)

            if ackNUM >= self.window_base:
                self.window_base = ackNUM + 1
                self.simulator.stop_timer(self.entity) 
                if self.window_base != self.next_seq_num:
                    self.simulator.start_timer(self.entity, self.timer_interval)

                while len(self.app_layer_buffer) > 0 and self.next_seq_num < self.window_base + self.window_size:
                    payload = self.app_layer_buffer.pop()
                    self.unACKed_buffer.append(self.create_pkt(self.next_seq_num, payload))
                    self.simulator.pass_to_network_layer(self.entity, self.unACKed_buffer[self.next_seq_num], self.is_ack(self.unACKed_buffer[self.next_seq_num]))
                    if self.window_base == self.next_seq_num:
                        self.simulator.start_timer(self.entity, self.timer_interval)
                    self.next_seq_num += 1 

        elif self.is_corrupt(byte_data):
                self.simulator.pass_to_network_layer(self.entity, self.last_ACK, self.is_ack(self.last_ACK))

        elif self.get_SEQ(byte_data) != self.expected_seq_num:
                self.simulator.pass_to_network_layer(self.entity, self.last_ACK, self.is_ack(self.last_ACK))

        else:
            try:
                dataTry = self.get_payload(byte_data)
            except Exception as e:
                self.simulator.pass_to_network_layer(self.entity, self.last_ACK, self.is_ack(self.last_ACK))
            self.simulator.pass_to_application_layer(self.entity, dataTry)
            self.last_ACK = self.create_pkt(self.expected_seq_num, "ACK")
            self.simulator.pass_to_network_layer(self.entity, self.last_ACK, self.is_ack(self.last_ACK))
            self.expected_seq_num += 1


    # This function is called by the simulator when a timer interrupt is triggered due to an ACK not being 
    # received in the expected time frame. All unACKed data should be resent, and the timer restarted
    def timer_interrupt(self):
        self.simulator.start_timer(self.entity, self.timer_interval)
        for i in range(self.window_base, self.next_seq_num, 1):
            self.simulator.pass_to_network_layer(self.entity, self.unACKed_buffer[i], self.is_ack(self.unACKed_buffer[i]))

    # This function should check to determine if a given packet is corrupt. The packet parameter accepted
    # by this function should contain a byte array
    def is_corrupt(self, packet):
        header = unpack("!HiHI" , packet[:12])
        checksum = header[2]
        cs_header = pack("!HiHI" , header[0], header[1], 0, header[3])
        pkt = cs_header + packet[12:]
        if checksum == self.mk_checksum(pkt):
            return False
        else: 
            return True

    def mk_checksum(self, pkt):
        if len(pkt) % 2 != 0:
            pkt = pkt + bytes(1)
        sum_words = 0
        for i in range(0, len(pkt), 2):
            word = pkt[i] << 8 | pkt[i+1]
            sum_words += word
            sum_words = (sum_words & 0xffff) + (sum_words >> 16)
        result = ~sum_words & 0xffff
        return result

    def create_pkt(self, seq_num, payload):
        if payload == "ACK":
            pkt = pack("!HiHI" , 0, seq_num, 0, 0)
            checksum = self.mk_checksum(pkt)
            pkt = pack("!HiHI" , 0, seq_num, checksum, 0)
        else:
            pkt = pack("!HiHI%is"%len(payload) , 128, seq_num, 0, len(payload), payload.encode())
            checksum = self.mk_checksum(pkt)
            pkt = pack("!HiHI%is"%len(payload) , 128, seq_num, checksum, len(payload), payload.encode())
        return pkt

    def get_payload(self,pkt):
        header = unpack("!HiHI" , pkt[:12])
        data = unpack("!%is"%header[3] , pkt[12:])
        data = data[0].decode()
        return data

    def is_ack(self,pkt):
        header = unpack("!HiHI" , pkt[:12])
        if header[0] == 0:
            return True
        else:
            return False

    def get_SEQ(self,pkt):
        header = unpack("!HiHI" , pkt[:12])
        return header[1]

    def get_ACK(self, pkt):
        header = unpack("!HiHI" , pkt[:12])
        return header[1]

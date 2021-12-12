from layer_header import LayerHeader
from struct import pack, unpack

class ARPHeader(LayerHeader):
    def __init__(self, pkt):
        header_length = 28
        self.header_bytes = pkt[:header_length]
        header_unpacked = unpack("!HHBBH6sI6sI", self.header_bytes)

        self.hardware_type = header_unpacked[0]
        self.protocol_type = header_unpacked[1]

        self.hardware_address_len = header_unpacked[2]
        self.protocol_address_len = header_unpacked[3]
        
        self.opcode = header_unpacked[4]
        self.sender_hardware_address = header_unpacked[5]
        self.sender_protocol_address = header_unpacked[6]
        self.target_hardware_address = header_unpacked[7]
        self.target_protocol_address = header_unpacked[8]

    def protocol(self):
        return "ARP"

    def header_bytes(self):
        return self.header_bytes

    def print_header(self):
        print("")
        print("ARP HEADER: ")
        line_width = (96+4)

        ####################################################################
        # Print first line
        print("-"*line_width)
        
        # Compose the contents of the first row of the header
        hardware_str = "HTYPE: " + hex(self.hardware_type)
        white_space = (24 - len(hardware_str))//2
        row_str = "|" + " "*white_space + hardware_str + " "*white_space + "|"

        ptype_str = "PTYPE: " + hex(self.protocol_type)
        white_space = (24 - len(ptype_str))//2
        row_str += " "*white_space + ptype_str + " "*white_space + "|"

        hlen_str = "HLEN: " + hex(self.hardware_address_len)
        white_space = (12 - len(hlen_str))//2
        row_str += " "*white_space + hlen_str + " "*white_space + "|"

        plen_str = "PLEN: " + hex(self.protocol_address_len)
        white_space = (12 - len(plen_str))//2
        row_str += " "*white_space + plen_str + " "*white_space + "|"

        oper_str = "OPER: " + hex(self.opcode)
        white_space = (24 - len(oper_str))//2
        row_str += " "*white_space + oper_str + " "*white_space + "|"


        # Print the first row of the header
        print(row_str)


        ####################################################################
        # Print a line divider
        print("-"*121)

        sha_str = "SHA: " + self.format_MAC_addr(self.sender_hardware_address)
        white_space = (72 - len(sha_str))//2
        row_str = " "*white_space + sha_str + " "*white_space + "|"

        spa_str = "SPA: " + self.format_IPv4_addr(self.sender_protocol_address)
        white_space = (48 - len(spa_str))//2
        row_str += " "*white_space + spa_str + " "*white_space + "|"


        # Print the first row of the header
        print(row_str)


        ####################################################################
        # Print a line divider
        print("-"*121)

        tha_str = "THA: " + self.format_MAC_addr(self.target_hardware_address)
        white_space = (72 - len(tha_str))//2
        row_str = " "*white_space + tha_str + " "*white_space + "|"

        tpa_str = "TPA: " + self.format_IPv4_addr(self.target_protocol_address)
        white_space = (48 - len(tpa_str))//2
        row_str += " "*white_space + tpa_str + " "*white_space + "|"
        
        # Print the first row of the header
        print(row_str)

        ####################################################################
        # Print a line divider
        print("-"*121)

        return super().print_header()
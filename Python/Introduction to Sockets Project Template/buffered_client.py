# TODO: add any import statements required
from socket import *
from struct import pack, unpack
from buffered_server import FIXED_LENGTH


class BufferedTCPClient:

    def __init__(self, server_host='localhost', server_port=36001, buffer_size=1024):
        self.buffer_size = buffer_size
        self.clientSocket= socket(AF_INET,SOCK_STREAM)
        self.clientSocket.connect((server_host, server_port))

        # TODO: Create a socket and establish a TCP connection with server 


    # This method is called by the autograder. You must implement it, and you cannot change the method signature. It should accept a message
    # from the user, which is packed according to the format specified for this assignment and then sent into the socket.
    # TODO: * Send a message to the server containing the message passed in to the function. 
    #           * Remember to pack it using the format defined in the instructions. 
    def send_message(self, message):
        print("CLIENT: Attempting to send a message...")
        print(message)

        formatMessage= pack("!I"+ str(len(message))+"s",len(message),message.encode())
        self.clientSocket.send(formatMessage)


    # This method is called by the autograder. You must implement it, and you cannot change the method signature. It should wait to receive a 
    # message from the socket, which is then returned to the user. It should return two values: the message received and whether or not it was received 
    # successfully. In the event that it was not received successfully, return an empty string for the message.
    # TODO: * Return the *string* sent back by the server. This should be the same string you sent, except that first 10 characters will have been removed
    #           * Be sure to set the bufsize parameter to self.buffer_size when calling the socket's receive function
    #           * Remember that we're sending packed messages back and forth, for the format defined in the assignment instructions. You'll have to unpack
    #             the message and return just the string. Don't return the raw response from the server.
    #       * Handle any errors associated with the server disconnecting
    def receive_message(self):
        print("CLIENT: Attempting to receive a message...")

        messageRecieved= True
        buffer= b""
        message= self.clientSocket.recv(FIXED_LENGTH)

        if message:
            beginning = message[0:4]
            beginning= unpack("!I", beginning)[0]
            ending= message[4:]
            while len(ending)< beginning:
                changeBuff= min(self.buffer_size, beginning- len(ending))
                message= self.clientSocket.recv(changeBuff)
                ending+= message
            return (ending.decode(),messageRecieved)
        
        else:
            messageRecieved= False
            return (buffer.decode(), messageRecieved)

        


    # This method is called by the autograder. You must implement it, and you cannot change the method signature. It should close your socket.
    # TODO: Close your socket
    def shutdown(self):
        print("Client: Attempting to shut down...")
        
        self.clientSocket.close()

        
if __name__ == "__main__":
    l = BufferedTCPClient(server_host="localhost", server_port=36001)

    l.send("Four score and seven years ago")
    response = l.receive_message()
    print(response)

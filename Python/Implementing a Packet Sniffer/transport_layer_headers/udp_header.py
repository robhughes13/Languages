from layer_header import LayerHeader
from struct import pack, unpack

class UDPHeader(LayerHeader):
    def __init__(self, pkt):
        header_length = 8
        self.header_bytes = pkt[:header_length]
        header_unpacked = unpack("!HHHH", self.header_bytes)
        self.source_port = header_unpacked[0]
        self.dest_port = header_unpacked[1]
        self.length = header_unpacked[2]
        self.checksum = header_unpacked[3]

    def protocol(self):
        return "UDP"

    def header_bytes(self):
        return self.header_bytes

    def print_header(self):
        print("")
        print("UDP HEADER: ")
        line_width = (96+4)

        ####################################################################
        # Print first line
        print("-"*line_width)
        
        # Compose the contents of the first row of the header
        version_str = "SOURCE PORT: " + str(self.source_port)
        white_space = (48 - len(version_str))//2
        first_row_str = "|" + " "*white_space + version_str + " "*white_space + "|"

        ihl_str = "DEST PORT: " + str(self.dest_port)
        white_space = (48 - len(ihl_str))//2
        first_row_str += " "*white_space + ihl_str + " "*white_space + "|"

        # Print the first row of the header
        print(first_row_str)
        


        ####################################################################
        # Print first line
        print("-"*line_width)
        
        # Compose the contents of the first row of the header
        version_str = "LENGTH: " + str(self.length)
        white_space = (48 - len(version_str))//2
        first_row_str = "|" + " "*white_space + version_str + " "*white_space + "|"

        # Compose the contents of the first row of the header
        version_str = "CHECKSUM: " + str(self.checksum)
        white_space = (48 - len(version_str))//2
        first_row_str += " "*white_space + version_str + " "*white_space + "|"

        # Print the first row of the header
        print(first_row_str)


        ####################################################################
        # Print a line divider
        print("-"*line_width)

        return super().print_header()
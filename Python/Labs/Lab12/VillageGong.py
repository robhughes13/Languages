#VillageGong.py
#Rob Hughes

import re

file = input("Enter the filename: ")

filename = open(file, "r")


for line in filename:
    if len(line)>3:
        tok = re.compile(":")
        tokenlist = tok.split(line)
        tokenlist = [ s for s in tokenlist if len(s) > 0]
        hour = int(tokenlist[0])
        minute = int(tokenlist[1])
        seconds = int(tokenlist[2])
    
        if (minute % 10) * 60 == 0 and seconds == 0:
            print(seconds)
        elif seconds == 0:
            seconds = (10 - minute % 10) * 60
            print(seconds)
        else:
            seconds = 600-(seconds + ((minute % 10) * 60))
            print(seconds)
        
    
    

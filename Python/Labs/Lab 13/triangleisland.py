#Rob Hughes
#Triangle island

import re
import math

inputFile= open("island.txt", 'r')
number=0
for line in inputFile:
    if len(line)<4:
        numIslands= int(line)
    else:
        tok= re.compile(" ")
        tokenlist= tok.split(line)
        tokenlist=[s for s in tokenlist if len(s)>0]
        a= int(tokenlist[0])
        b=int(tokenlist[1])
        c=int(tokenlist[2])
        d= math.sqrt((a**2)+(b**2))
        number+=1
        if (a+c)> (b-c+d):
            print(str(number) + " go East.")
        else:
            print(str(number)+ " go West.")
    
        
inputFile.close()


    
        
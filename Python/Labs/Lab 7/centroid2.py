#Anthony Sasso
#centroid.py

#input
import re

x=[ ]
y=[ ]
pop=[ ]
totalx=0
totalPop=0
totaly=0
filename=input("What is the filename?  ")
inFile= open(filename,"r")
for line in inFile:
    tok = re.compile("[ \n]")
    tokenlist = tok.split(line)
    tokenlist = [ s for s in tokenlist if len(s) > 0 ]
    x=float(tokenlist[0])
    y=float(tokenlist[1])
    pop=float(tokenlist[2])
    totalx=totalx+(x*pop)
    totaly=totaly+(y*pop)
    totalPop+=pop
cx=totalx/totalPop
cy=totaly/totalPop

print("Centroid for population is ({0:.2f},{1:.2f})".format(cx,cy))

    

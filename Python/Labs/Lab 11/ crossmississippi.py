#Mississippi
#Rob Hughes
import re

file = input("What is the name of the file?" )

filename = open(file, "r")

east= ["WI", "IL", "KY", "TN", "MS"]
west= ["MN", "IA", "MO", "AR", "LA"]
 
stateNum=[]
states =[]

for line in filename:
    line = line.strip()
    tok = re.compile(" ")
    tokenlist = tok.split(line)
    tokenlist = [ s for s in tokenlist if len(s) > 0]
    if tokenlist[-1] == "trips":
        continue
    elif tokenlist[0] == "Trip":
        stateNum.append(int(tokenlist[3]))
    else:
        states.append(tokenlist[-1])
            
        
startline =0
tripNum = 1
for num in stateNum:
    count = 0
    for i in range(startline, startline + (num-1)):
        if states[i] in east and states[i+1] in west:
            count+=1
        elif states[i] in west and states[i+1] in east:
            count += 1
    if count == 1:        
        print("Trip",tripNum, "crosses the Mississippi", count, "time." )
    else:
        print("Trip",tripNum, "crosses the Mississippi", count, "times." )
    tripNum += 1
    startline += num

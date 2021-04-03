#meetingtimes.py
#Rob Hughes


import re

filename= input("What is the name of the file?:  ")

file = open(filename, 'r')

M = [7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6]
T = [7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6]
W = [7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6]
R = [7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6]
F = [7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6]

print("Here are the possible meeting times:")

for line in file:
    tok = re.compile("[- ]")
    tokenlist = tok.split(line)
    tokenlist = [ s for s in tokenlist if len(s) > 0]
    if 'M' in line:
        if int(tokenlist[2]) > 6:
            M.append(7)
            del M[M.index(int(tokenlist[1])):M.index(int(tokenlist[2]))]
            del M[-1]
        else:
            del M[M.index(int(tokenlist[1])):M.index(int(tokenlist[2]))]
            
    if 'T' in line:
        if int(tokenlist[2]) > 6:
            T.append(7)
            del T[T.index(int(tokenlist[1])):T.index(int(tokenlist[2]))]
            del T[-1]
        else:
            del T[T.index(int(tokenlist[1])):T.index(int(tokenlist[2]))]
            
    if 'W' in line:
        if int(tokenlist[2]) > 6:
            W.append(7)
            del W[W.index(int(tokenlist[1])):W.index(int(tokenlist[2]))]
            del W[-1]
        else:
            del W[W.index(int(tokenlist[1])):W.index(int(tokenlist[2]))]
            
    if 'R' in line:
        if int(tokenlist[2]) > 6:
            R.append(7)
            del R[R.index(int(tokenlist[1])):R.index(int(tokenlist[2]))]
            del R[-1]
        else:
            del R[R.index(int(tokenlist[1])):R.index(int(tokenlist[2]))]
            
    if 'F' in line:
        if int(tokenlist[2]) > 6:
            F.append(7)
            del F[F.index(int(tokenlist[1])):F.index(int(tokenlist[2]))]
            del F[-1]
        else:
            del F[F.index(int(tokenlist[1])):F.index(int(tokenlist[2]))]
mVal=""
for val in M:
    newVal= str(val)
    mVal+=newVal+","
adjustedM=mVal[:-1]

tVal=""
for val in T:
    newVal= str(val)
    tVal+=newVal+","
adjustedT=tVal[:-1]

wVal=""
for val in W:
    newVal= str(val)
    wVal+=newVal+","
adjustedW=wVal[:-1]

rVal=""
for val in R:
    newVal= str(val)
    rVal+=newVal+","
adjustedR=rVal[:-1]

fVal=""
for val in F:
    newVal= str(val)
    fVal+=newVal+","
adjustedF=fVal[:-1]

if not M:
            print("Monday is booked.")
else:
            print("M", adjustedM)
    
if not T:
            print("Tuesday is booked.")
else:
            print("T", adjustedT)

if not W:
            print("Wednesday is booked.")
else:    
            print("W", adjustedW)
            
if not R:
            print("Thursday is booked.")
else:    
            print("R", adjustedR)            
            
if not F:
            print("Friday is booked.")
else:    
            print("F", adjustedF)            
            
file.close()        
            
            

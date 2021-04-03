#lottery.py
#rob Hughes

import re
userNum= str(input("Enter the 6 numbers on your ticket:  "))
print()
machine= str(input("Enter the 6 winning numbers:  "))
print()

tok= re.compile(" ")
U= tok.split(userNum)
U= [s for s in U if len(s)>0]


tok2= re.compile(" ")
M= tok2.split(machine)
M= [s for s in M if len(s)>0]

count=0
for i in range(0,len(U)):
    for j in range(0, len(M)):
        if U[int(i)]== M[int(j)]:
            count+=1
            break


if count==1:
    print("You matched 1 number!")
elif count==0:
    print("You didn't match any numbers, sorry.")
else:
    print("You matched "+str(count)+" numbers!")

#Rob Hughes
#phonenumber.py
#user will enter a 7 letter word, and a phone number will be computed

s= str(input("Enter a 7 letter word:  "))
print()
val=0
s= s.lower()
while val in range(0,len(s)):
    if val==3:
        print('-',end="")
    if s[val]== "a" or s[val]=="b" or s[val]== "c":
        print('2',end="")
    elif s[val]=='d' or s[val]== 'e' or s[val]=='f':
        print('3',end="")
    elif s[val]== 'g' or s[val]== 'h' or s[val]== 'i':
        print('4',end="")
    elif s[val]=='j' or s[val]=='k' or s[val]=='l':
        print('5',end="")
    elif s[val]=='m' or s[val]=='n' or s[val]== 'o':
        print('6', end="")
    elif s[val]=='p' or s[val]=='r' or s[val]=='s':
        print('7',end="")
    elif s[val]=='t' or s[val]=='u' or s[val]=='v':
        print('8',end="")
    elif s[val]=='w' or s[val]=='x' or s[val]== 'y':
        print('9',end="")
    else:
        print('0',end="")
    val+=1

#Login Accounting
#Rob Hughes


import re

file = open(input("Which file has login data?  "), "r")

login = {}
for line in file:
    tok = re.compile(" ")
    tokenlist = tok.split(line)
    tokenlist = [s for s in tokenlist if len(s) > 0]
    if len(tokenlist) > 8:
        username = tokenlist[0]
        timeClock = tokenlist[9]
        if 9 < len(timeClock) < 11:
            days = int(timeClock[1])
            hours = int(timeClock[3:5])
            minCalc = int(timeClock[6:8])
            minutes = days * 1440 + hours * 60 + minCalc
        elif len(timeClock) == 11:
            days = int(timeClock[1:3])
            hours = int(timeClock[4:6])
            minCalc = int(timeClock[7:9])
            minutes = days * 1440 + hours * 60 + minCalc
        elif len(timeClock) == 12:
            days = int(timeClock[1:4])
            hours = int(timeClock[5:7])
            minCalc = int(timeClock[8:10])
            minutes = days * 1440 + hours * 60 + minCalc
        else:
            hours = int(timeClock[1:3])
            minCalc = int(timeClock[4:6])
            minutes = hours * 60 + minCalc
    if username in login:
        login[username] += minutes
    else:
        login[username] = minutes
    minutes = 0

print()
print("Which users would you like to look up?  Enter names one at a time.")
print("Simply hit enter to quit.")


success = True
while success:
    inputUsername = input("Enter a username:  ")
    if inputUsername in login:
        print(inputUsername, "has", login[inputUsername], "minutes of login time.")
    elif len(inputUsername) == 0:
        success = False
        break
    else:
        print("Sorry, I have no data on {0:s}." .format(inputUsername))
        
print("Good bye!")

    
    
    

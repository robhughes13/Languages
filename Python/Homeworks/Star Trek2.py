#Rob Hughes

import re
inFile= open("stars.txt","r")

success = False
while not success:
    try:
        warpSpeed = float(input("What is the desired warp speed? (1-9) "))
        if warpSpeed >=1 and warpSpeed<= 9:
            success = True
        else:
            print("Sorry, the number is out of range. Try again.")
    except ValueError:
        print("Sorry you need to enter a real number. Try again.")



for line in inFile:
    planet= line[0:15]
    lightYears=float(line[16:])
    days= (365.2425*(lightYears))/ (warpSpeed**3)
    endDays= int(days)
    hours1= days-endDays
    hours2= 24*hours1
    hours3=int(hours2+0.5)
    if hours3>1:
        print("{0:15s} {1:d} days {2:d} hours".format(planet,days,hours3))
    elif hours3==1:
        print("{0:15s} {1:d} days {2:d} hour".format(planet,days,hours3))
    else:
        print("{0:15s} {1:d} days".format(planet))

inFile.close()
    

    

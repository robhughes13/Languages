#Star Trek
#Rob Hughes



file = open("stars.txt", "r")
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
        
        
        
distance = []
for line in file:
    distance.append(float(line[15:-1]))
    

file = open("stars.txt", "r")
starName = []
for line in file:
    starName.append(line [:15])
    
years =[distance/warpSpeed**3 for distance in distance]
days = [year * 365.2425 for year in years]
extras = [day % 1 for day in days]
hours = [extra*24 for extra in extras]
hoursApprox = [round(hour, 0) for hour in hours]


print()
for i in range(0, len(starName)):
    print(starName[i], int(days[i]), "days", int(hoursApprox[i]), "hours")

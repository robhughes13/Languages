#3except.py
#Rob Hughes

success = False
while not success:
    try:
        fileName = input("Which file contains the Olympic host data? ")
        file = open(fileName)
        success = True
        
            
    except FileNotFoundError:
        print("Sorry, I can't find that file. Try again.")
        
host = {}
for line in file:
    city = line[5: -1] 
    year = int(line[0:4])
    host[year] = city 
    
yearOlympic = int(input("Enter a year: "))
if yearOlympic in host:
    print("The host in {0:d} was {1:s}.".format(yearOlympic, host[yearOlympic]))
else:
    print("I have no data on that year.")

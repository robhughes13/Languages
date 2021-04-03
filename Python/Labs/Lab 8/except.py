#except.py
#Rob Hughes

success = False
while not success:
    try:
        n = int(input("Please enter a positive integer: "))
        if n >0:
            success = True
            nSquared = n*n
            print("Your number squared is {0:2d}".format(nSquared))
        else:
            print("Your number is not positive. Try again.")
        
    except:
        print("Sorry, I don't understand. Try again.")


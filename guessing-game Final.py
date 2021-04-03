# Rob Hughes
# This plays the guessing game, guessing a random integer from 1 to 99, making as few guesses as possible.
#

import random
import math

def mean(val1,val2):
    return ((val1+val2)/2)

def expected(x):
    """Computes the expected number of guesses for the given maximum value:
       it is based on a binary search (continuous halving)"""
    return math.ceil(math.log(x, 2))
def generateGuess(num1):
    return num1

MAX_VALUE = 99 # Interval of valid values to guess [0, 99]
MAX_GUESSES = expected(MAX_VALUE)


def run(target):
    """Tells what to say and do for each guess"""
    #amount of guesses it takes, added throughout the game
    numGuess = 0
    #lowest possible value the target could be
    lowerBound=0
    #highest possible value the target could be
    upperBound=MAX_VALUE

    beginning=int(input("Guess the random value from 1 to 99.Hint? If so, enter a negative number:"))
    if beginning>0:
        guess=int(input("Guess a number from 1 to 99:"))
    elif beginning<0:
        guess=int(input("Guess 50:"))
    while target != guess:
        if guess>target:
            print("Lower")
            upperBound=guess
            midPoint=(int(mean(upperBound,lowerBound)))
            numGuess=numGuess+1
            hint= int(input("Hint? If so, enter a negative number:"))
            if hint<0:
                guess=int(input("Guess"+str(generateGuess(midPoint))+":"))
            elif hint>0:
                guess=int(input("Guess a number from 1 to 99:"))
        elif guess<target:
            print("Higher")
            lowerBound=guess
            midPoint=(int(mean(upperBound,lowerBound)))
            numGuess=numGuess+1
            hint= int(input("Hint? If so, enter a negative number:"))
            if hint<0:
                guess=int(input("Guess"+str(generateGuess(midPoint))+":"))
            elif hint>0:       
                guess=int(input("Guess a number from 1 to 99:"))
    numGuess=numGuess+1
    return numGuess

def main():
    

    # play the game
    numGuess = run(random.randint(1, MAX_VALUE))
    expect = expected(MAX_VALUE)

    if numGuess==expect:
        print("Congratulations! You equaled expectation with "+str(numGuess)+" guesses.")
    elif numGuess>expect:
        print("You made "+str(numGuess)+" guesses; we expected "+str(expect)+" guesses.")
    elif numGuess<expect:
        print("Nice! You did better than expected with "+str(numGuess)+" guesses; we expected "+str(expect)+" guesses.")


    # this will show the amount of guesses it took the user, compared to the expected value of guesses

if __name__ == "__main__":
    main()

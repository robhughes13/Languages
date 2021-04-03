#Lab 12
#The Bookmaker
#Rob Hughes

import re

file = open("bookmaker.txt", "r")
betNum = 1
profit = 0
for line in file:
    if len(line) > 9:
        tok = re.compile("[$, ]")
        tokenlist = tok.split(line)
        tokenlist = [s for s in tokenlist if len(s) > 0]
        if len(tokenlist) == 3:
            bet = int(tokenlist[0])
            payout = bet * 2
            profit += 0.09 * bet
            print("Bet", betNum, "payout is $ {0:0.2f}" .format(payout))
            betNum += 1
        elif len(tokenlist) == 4:
            bet = int(tokenlist[0])
            a = int(tokenlist[1])
            b = int(tokenlist[3])
            payout = bet + bet * (a/b)
            profit += 0.09 * bet
            print("Bet", betNum, "payout is $ {0:0.2f}" .format(payout))
            betNum += 1
        else:
            bet = int(tokenlist[0])
            a = int(tokenlist[1])
            b = int(tokenlist[3])
            payout = bet + bet * (b/a)
            profit += 0.09 * bet
            print("Bet", betNum, "payout is $ {0:0.2f}" .format(payout))
            betNum += 1
            
print("Expected bookmaker profit is $", profit)
        

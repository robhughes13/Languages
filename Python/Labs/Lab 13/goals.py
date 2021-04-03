#Rob Hughes
#Lab 13



file= open("goals.txt", 'r')

import re

lineNum=1
score1=0
score2=0
playerlist1=[]
playerlist2=[]
gameNum=1
for line in file:
    tok= re.compile("[()\n ]")
    tokenlist= tok.split(line)
    tokenlist=[s for s in tokenlist if len(s)>0]
    if lineNum==1:
        lineNum+=1
        continue
    elif '*' in line:
        if score1>score2:
            winningPlay= playerlist1[(score2*2):(score2*2)+2]
            playerFirst= winningPlay[0]
            playerLast= winningPlay[1]
            print("Game {0:d}, {1:s} {2:d} {3:s} {4:d}, winning goal by {5:s} {6:s} ({7:s})\n".format(gameNum,team1,score1,team2,score2,playerFirst,playerLast,team1))
        else:
            winningPlay= playerlist2[(score1*2):(score1*2)+2]
            playerFirst= winningPlay[0]
            playerLast= winningPlay[1]
            print("Game {0:d}, {1:s} {2:d} {3:s} {4:d}, winning goal by {5:s} {6:s} ({7:s})\n".format(gameNum,team1,score1,team2,score2,playerFirst,playerLast,team2))
        break
    elif len(tokenlist)==5:
        if score1==0 and score2==0:
            team1= tokenlist[2]
            team2= tokenlist[4]
        else:
            if score1>score2:
                winningPlay= playerlist1[(score2*2):(score2*2)+2]
                playerFirst= winningPlay[0]
                playerLast= winningPlay[1]
                print("Game {0:d}, {1:s} {2:d} {3:s} {4:d}, winning goal by {5:s} {6:s} ({7:s})\n".format(gameNum,team1,score1,team2,score2,playerFirst,playerLast,team1))
            else:
                winningPlay= playerlist2[(score1*2):(score1*2)+2]
                playerFirst= winningPlay[0]
                playerLast= winningPlay[1]
                print("Game {0:d}, {1:s} {2:d} {3:s} {4:d}, winning goal by {5:s} {6:s} ({7:s})\n".format(gameNum,team1,score1,team2,score2,playerFirst,playerLast,team2))
            team1= tokenlist[2]
            team2= tokenlist[4]
            score1=0
            score2=0
            gameNum+=1
            playerlist1=[]
            playerlist2=[]
    elif len(tokenlist)==4:
        if tokenlist[0]== team1:
            score1+=1
            playerlist1.append(tokenlist[2])
            playerlist1.append(tokenlist[3])
            
        else:
            score2+=1
            playerlist2.append(tokenlist[2])
            playerlist2.append(tokenlist[3])
   
        
        
        

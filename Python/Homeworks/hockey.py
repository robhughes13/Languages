#Rob Hughes
import re
file = open('hockey.txt', 'r')
V={}
H={}
lineValue = ' '
pm = 0
homePM = 1
visitorPM = 1
home = ' '
visitor = ' '
for line in file:
    line = line[:-1]
    tok = re.compile("[ ()]")
    tokenlist = tok.split(line)
    tokenlist = [s for s in tokenlist if len(s) > 0]
    
    if 'Goalie' in line:
        continue
    elif "versus" in line:
        home = str(tokenlist[2])
        visitor = str(tokenlist[0])
     
    if lineValue == 'none' and home in line:
        lineValue = 'none'
    elif lineValue == 'none' and visitor in line:
        lineValue = 'none'
    elif home in line and 'Power Play' not in line:
        lineValue = 'home'
    elif visitor in line and 'Power Play' not in line:
        lineValue = 'visitor'
    if 'Power Play' in line:
        lineValue = 'none'
        homePM= 0
        visitorPM = 0 
    if home in line and 'goal' in line and "Power Play" not in line:
        lineValue = 'visitor'
        homePM = 1
        visitorPM = -1
    elif visitor in line and 'goal' in line and '(Power Play)' not in line:
        lineValue = 'visitor'
        homePM = -1
        visitorPM = 1
# Name 2
    if lineValue == 'home' and "-" in line and 'Wing' not in line and len(tokenlist) != 6:
        name = tokenlist[2] + " " + tokenlist[3]
        if name in H:
            H[name][2] += homePM
        else:
            
            H[name] = [tokenlist[0], tokenlist[4], pm]
            H[name][2] += homePM
    elif lineValue == 'visitor' and "-" in line and 'Wing' not in line and len(tokenlist) != 6:
        name = tokenlist[2] + " " + tokenlist[3]
        if name in V:
            V[name][2] += visitorPM
        else:
            
            V[name] = [tokenlist[0], tokenlist[4], pm]
            V[name][2] += visitorPM
  
    if 'Wing' in line and lineValue == 'home' and len(tokenlist) != 7:
        name = tokenlist[3] + " " + tokenlist[4]
        if int(tokenlist[5]) < 10:
            tokenlist[0] = str(" " + str(tokenlist[0]))
        if name in H:
            H[name][2] += homePM
        else:
            position = tokenlist[0] + " " + tokenlist[1]
            H[name] = [position, tokenlist[5], pm]
            H[name][2] += homePM
    elif 'Wing' in line and lineValue == 'visitor' and len(tokenlist) != 7:
        name = tokenlist[3] + " " + tokenlist[4]
        if int(tokenlist[5]) < 10:
            tokenlist[0] = str(" " + str(tokenlist[0]))
        if name in V:
            V[name][2] += visitorPM
        else:
            
            position = tokenlist[0] + " " + tokenlist[1]
            V[name] = [position, tokenlist[5], pm]
            V[name][2] += visitorPM

# Name 3

    if lineValue == 'home' and "-" in line and 'Wing' not in line and len(tokenlist) == 6:
        name = tokenlist[2] + " " + tokenlist[3] + " " + tokenlist[4]
        
        if name in H:
            H[name][2] += homePM
        else:
            
            H[name] = [tokenlist[0], tokenlist[5], pm]
            H[name][2] += homePM
    elif lineValue == 'visitor' and "-" in line and 'Wing' not in line and len(tokenlist) == 6:
        name = tokenlist[2] + " " + tokenlist[3]+ " " + tokenlist[4]
        if name in V:
            V[name][2] += visitorPM
        else:          
            V[name] = [tokenlist[0], tokenlist[5], pm]
            V[name][2] += visitorPM
  
    
    if 'Wing' in line and lineValue == 'home' and len(tokenlist) == 7:
        name = tokenlist[3] + " " + tokenlist[4] + " " + tokenlist[5]
        if int(tokenlist[6]) < 10:
            tokenlist[0] = str(" " + str(tokenlist[0]))
        if name in H:
            H[name][2] += homePM
        else:
            position = tokenlist[0] + " " + tokenlist[1]
            H[name] = [position, tokenlist[6], pm]
            H[name][2] += homePM
    elif 'Wing' in line and lineValue == 'visitor' and len(tokenlist) == 7:
        name = tokenlist[3] + " " + tokenlist[4] + " " + tokenlist[5]
        if int(tokenlist[6]) < 10:
            tokenlist[0] = str(" " + str(tokenlist[6]))
        if name in V:
            V[name][2] += visitorPM
        else:
            
            position = tokenlist[0] + " " + tokenlist[1]
            V[name] = [position, tokenlist[6], pm]
            V[name][2] += visitorPM


print('Visitng team ' + visitor)
for key in V:
    if V[key][2] > 3:
        print('#{:>2} {:<20} {:<11}'.format(V[key][1], key, V[key][0]) + ' rating: {:>2}'.format(str(V[key][2])))
for key in V:
    if V[key][2] == 3:
        print('#{:>2} {:<20} {:<11}'.format(V[key][1], key, V[key][0]) + ' rating: {:>2}'.format(str(V[key][2])))
for key in V:
    if V[key][2] == 2:
        print('#{:>2} {:<20} {:<11}'.format(V[key][1], key, V[key][0]) + ' rating: {:>2}'.format(str(V[key][2])))
for key in V:
    if V[key][2] == 1:
        print('#{:>2} {:<20} {:<11}'.format(V[key][1], key, V[key][0]) + ' rating: {:>2}'.format(str(V[key][2])))
for key in V:
    if V[key][2] == 0:
        print('#{:>2} {:<20} {:<11}'.format(V[key][1], key, V[key][0]) + ' rating: {:>2}'.format(str(V[key][2])))
for key in V:
    if V[key][2] == -1:
        print('#{:>2} {:<20} {:<11}'.format(V[key][1], key, V[key][0]) + ' rating: {:>2}'.format(str(V[key][2])))
for key in V:
    if V[key][2] == -2:
        print('#{:>2} {:<20} {:<11}'.format(V[key][1], key, V[key][0]) + ' rating: {:>2}'.format(str(V[key][2])))
for key in V:
    if V[key][2] ==-3:
        print('#{:>2} {:<20} {:<11}'.format(V[key][1], key, V[key][0]) + ' rating: {:>2}'.format(str(V[key][2])))
for key in V:
    if V[key][2] < - 3:
        print('#{:>2} {:<20} {:<11}'.format(V[key][1], key, V[key][0]) + ' rating: {:>2}'.format(str(V[key][2])))

print(" ")
print("Home team " + home)

for key in H:
    if H[key][2] > 3:
        print('#{:>2} {:<20} {:<11}'.format(H[key][1], key, H[key][0]) + ' rating:{:>3}'.format(str(H[key][2])))
for key in H:
    if H[key][2] == 3:
        print('#{:>2} {:<20} {:<11}'.format(H[key][1], key, H[key][0]) + ' rating:{:>3}'.format(str(H[key][2])))
for key in H:
    if H[key][2] == 2:
        print('#{:>2} {:<20} {:<11}'.format(H[key][1], key, H[key][0]) + ' rating:{:>3}'.format(str(H[key][2])))
for key in H:
    if H[key][2] == 1:
        print('#{:>2} {:<20} {:<11}'.format(H[key][1], key, H[key][0]) + ' rating:{:>3}'.format(str(H[key][2])))          
for key in H:
    if H[key][2] == 0:
        print('#{:>2} {:<20} {:<11}'.format(H[key][1], key, H[key][0]) + ' rating:{:>3}'.format(str(H[key][2])))
for key in H:
    if H[key][2] == -1:
        print('#{:>2} {:<20} {:<11}'.format(H[key][1], key, H[key][0]) + ' rating:{:>3}'.format(str(H[key][2])))
for key in H:
    if H[key][2] == -2:
        print('#{:>2} {:<20} {:<11}'.format(H[key][1], key, H[key][0]) + ' rating:{:>3}'.format(str(H[key][2])))
for key in H:
    if H[key][2] == -3:
        print('#{:>2} {:<20} {:<11}'.format(H[key][1], key, H[key][0]) + ' rating:{:>3}'.format(str(H[key][2])))
for key in H:
    if H[key][2] < - 3:
        print('#{:>2} {:<20} {:<11}'.format(H[key][1], key, H[key][0]) + ' rating:{:>3}'.format(str(H[key][2])))



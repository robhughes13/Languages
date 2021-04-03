#Time Zones
#Rob Hughes
#01/28/19
#The goal of this program is to state the times in Honolulu and Adelaide,
#given the time in Greenville

#input
hourGville= int(input("What is the hour of the time?(1-12):  "))
minuteGville= int(input("How many minutes into the hour(00-59)?:  "))
aorpGville= str(input("Enter 'a' for AM, and 'p' for PM:  "))

#calculations
#Honolulu

if hourGville < 5:
    if aorpGville== 'a':
        hourHonolulu= 12-(5-hourGville)
        minuteHonolulu= minuteGville
        aorpHonolulu= "pm"
        dayHono= " yesterday."
        if minuteHonolulu==0:
            minuteHonolulu= str(minuteHonolulu)+'0'
        elif 0<minuteHonolulu<10:
            minuteHonolulu= '0'+str(minuteHonolulu)
    else:
        aorpHonolulu= "am"
        hourHonolulu= 12-(5-hourGville)
        dayHono= "."
        minuteHonolulu= minuteGville
        if 0<minuteHonolulu<10:
            minuteHonolulu= '0'+str(minuteHonolulu)
        if minuteHonolulu==0:
            minuteHonolulu= str(minuteHonolulu)+'0'
        
        
if 12>hourGville >5:
    hourHonolulu= hourGville-5
    minuteHonolulu= minuteGville
    if aorpGville== 'a':
        aorpHonolulu= "am"
        dayHono= "."
        if minuteHonolulu==0:
            minuteHonolulu= str(minuteHonolulu)+'0'
        elif 0<minuteHonolulu<10:
                minuteHonolulu= '0'+str(minuteHonolulu)
    else:
        aorpHonolulu= "pm"
        dayHono= "."
        if minuteHonolulu==0:
            minuteHonolulu= str(minuteHonolulu)+'0'
        elif 0<minuteHonolulu<10:
            minuteHonolulu= '0'+str(minuteHonolulu)
if hourGville==12:
    hourHonolulu= hourGville-5
    minuteHonolulu= minuteGville
    if aorpGville== 'a':
        aorpHonolulu= "pm"
        dayHono= " yesterday."
        if minuteHonolulu==0:
            minuteHonolulu= str(minuteHonolulu)+'0'
        elif 0<minuteHonolulu<10:
            minuteHonolulu= '0'+str(minuteHonolulu)
    else:
        aorpHonolulu= "am"
        dayHono= "."
        if minuteHonolulu==0:
            minuteHonolulu= str(minuteHonolulu)+'0'
        elif 0<minuteHonolulu<10:
            minuteHonolulu= '0'+str(minuteHonolulu)

if hourGville==5:
    hourHonolulu= 12
    minuteHonolulu= minuteGville
    if aorpGville== 'a':
        aorpHonolulu= "am"
        dayHono= "."
        if minuteHonolulu==0:
            minuteHonolulu= str(minuteHonolulu)+'0'
        elif 0<minuteHonolulu<10:
            minuteHonolulu= '0'+str(minuteHonolulu)
    else:
        aorpHonolulu= "pm"
        dayHono= "."
        if minuteHonolulu==0:
            minuteHonolulu= str(minuteHonolulu)+'0'
        elif 0<minuteHonolulu<10:
            minuteHonolulu= '0'+str(minuteHonolulu)

#Adelaide

if aorpGville== 'p':
    hourAdelaide= (hourGville + 3)
    minuteAdelaide= (minuteGville + 30)
    if minuteAdelaide >= 60:
        hourAdelaide= (hourAdelaide + 1)
        minuteAdelaide= (minuteAdelaide - 60)
        if hourAdelaide >= 12:
            hourAdelaide= (hourAdelaide % 12)
            if hourAdelaide==0:
                hourAdelaide= 12
                aorpAdelaide= "pm"
                dayAde= " tomorrow."
                if minuteAdelaide==0:
                    minuteAdelaide= str(minuteAdelaide)+'0'
                elif 0<minuteAdelaide<10:
                    minuteAdelaide= '0'+str(minuteAdelaide)
            else:
                aorpAdelaide= "am"
                dayAde= " tomorrow."
                if minuteAdelaide==0:
                    minuteAdelaide= str(minuteAdelaide)+'0'
                elif 0<minuteAdelaide<10:
                    minuteAdelaide= '0'+str(minuteAdelaide)
        else:
            aorpAdelaide= "am"
            dayAde= " tomorrow."
            if minuteAdelaide==0:
                minuteAdelaide= str(minuteAdelaide)+'0'
            elif 0<minuteAdelaide<10:
                minuteAdelaide= '0'+str(minuteAdelaide)
    else:
        if hourAdelaide >= 12:
            hourAdelaide= (hourAdelaide % 12)
            aorpAdelaide= "am"
            dayAde= " tomorrow."
            if hourAdelaide==0:
                hourAdelaide= 12
            if minuteAdelaide==0:
                minuteAdelaide= str(minuteAdelaide)+'0'
            elif 0<minuteAdelaide<10:
                minuteAdelaide= '0'+str(minuteAdelaide)
        else:
            aorpAdelaide= "am"
            dayAde= " tomorrow."
            if minuteAdelaide==0:
                minuteAdelaide= str(minuteAdelaide)+'0'
            elif 0<minuteAdelaide<10:
                minuteAdelaide= '0'+str(minuteAdelaide)
else:
    hourAdelaide= (hourGville + 3)
    minuteAdelaide= (minuteGville + 30)
    if minuteAdelaide >= 60:
        hourAdelaide= (hourAdelaide + 1)
        minuteAdelaide= (minuteAdelaide - 60)
        if hourAdelaide >= 12:
            hourAdelaide= (hourAdelaide % 12)
            if hourAdelaide==0:
                hourAdelaide= 12
                aorpAdelaide= "am"
                dayAde= " tomorrow."
                if minuteAdelaide==0:
                    minuteAdelaide= str(minuteAdelaide)+'0'
                elif 0<minuteAdelaide<10:
                    minuteAdelaide= '0'+str(minuteAdelaide)
            else:
                aorpAdelaide= "pm"
                dayAde= "."
                if minuteAdelaide==0:
                    minuteAdelaide= str(minuteAdelaide)+'0'
                elif 0<minuteAdelaide<10:
                    minuteAdelaide= '0'+str(minuteAdelaide)
        else:
            aorpAdelaide= "pm"
            dayAde= "."
            if minuteAdelaide==0:
                minuteAdelaide= str(minuteAdelaide)+'0'
            elif 0<minuteAdelaide<10:
                minuteAdelaide= '0'+str(minuteAdelaide)
    else:
        if hourAdelaide >= 12:
            hourAdelaide= (hourAdelaide % 12)
            aorpAdelaide= "pm"
            dayAde= "."
            if hourAdelaide==0:
                hourAdelaide= 12
                if minuteAdelaide==0:
                    minuteAdelaide= str(minuteAdelaide)+'0'
                elif 0<minuteAdelaide<10:
                    minuteAdelaide= '0'+str(minuteAdelaide)
        else:
            aorpAdelaide= "pm"
            dayAde= "."
            if minuteAdelaide==0:
                minuteAdelaide= str(minuteAdelaide)+'0'
            elif 0<minuteAdelaide<10:
                minuteAdelaide= '0'+str(minuteAdelaide)
        
    
        

    
    


    




#Output
print ()
print("The time in Honolulu is "+str(hourHonolulu)+":"+str(minuteHonolulu)+ aorpHonolulu+dayHono)
print("The time in Adelaide is "+str(hourAdelaide)+":"+str(minuteAdelaide)+ aorpAdelaide+dayAde)
    
        
        
        
    

trust=True
attempts=0
while trust==True and attempts<3:
    startup= str(input("Can you trust me enough to answer one question?:   "))
    if "yes" in startup or "Yes" in startup or "maybe" in startup:
        answer= input(str("What percent of the things you said on Sunday night were alcoholically induced?:   "))
        print(answer,"\n" "Thanks for you time, now please text me that")
        trust=False
    else:
        attempts+=1
        print("\nLet's try this again \n")

if attempts>2:
    answer=input(str("Suck it, you have no choice now. What percent of the things you said on Sunday night were alcoholically induced?:   "))
    print(answer,"\n" "Thanks for you time, now please text me that")
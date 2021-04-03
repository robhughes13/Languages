#Rob Hughes
#Feb 4, 2019
#Program designed to find the costs of buying an amount of stocks
print("Welcome to the Stock Broker!")
print()
stockNum= int(input("How many securities would you like to purchase?: "))
val= 1
totalMarket=0
totalCommission=0
allCost=0
while val in range(1,stockNum+1):
    print("Purchase # "+str(val))
    shareName= str(input("Enter ticker symbol: "))
    print()
    shareAmount= int(input("How many shares are you buying?: "))
    print()
    sharePrice= float(input("What is the share price?: "))
    print()
    shareWorth= shareAmount*sharePrice
    if shareName== "SPY" or shareName== "VOO":
        commission= 25
    else:
        if shareWorth>= 10000:
            commission= shareWorth*0.005
        else:
            commission= 50
    totalCost= commission+shareWorth
    totalMarket+=shareWorth
    totalCommission+=commission
    allCost+=totalCost
    print("{0:<9d} shares of {1:4s} is worth   ${2:9.2f}".format(shareAmount,shareName,shareWorth))
    print("Commission is                       ${0:9.2f}".format(commission))
    print("Cost to purchase is                 ${0:9.2f}".format(totalCost))
    print()
    print()
    val+=1
print("--------------------------------------------------------------------")
print("Total market value is               ${0:9.2f}".format(totalMarket))
print("Total commission value is           ${0:9.2f}".format(totalCommission))
print("Total purchase cost is              ${0:9.2f}".format(allCost))
    

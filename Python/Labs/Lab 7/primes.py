#Anthony Sasso
#primes.py



#inuput
File = open("primenumbers.txt", "w")

finishingnum = int(input("What is the finishing number? "))

divisor = 0
count = 0
n = 2
while n <= finishingnum:
    if n% 10000 == 0:
        print(n)
    for i in range(2, int(n**(1/2))+1):
        if n % i ==0:
            divisor+= 1
    if divisor ==0:
        File.write(str(n) + "\n")
        count+=1
    n+=1
    divisor =0    

#printStatements
print()
print("We are complete!")
print("We found", count,"prime numbers.")
File.close()


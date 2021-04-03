#2except.py
#Rob Hughes

import re

line = input("Enter a line of text consisting of both words and numbers: ")

tok = re.compile(" ")
tokenlist = tok.split(line)
tokenlist = [ s for s in tokenlist if len(s) > 0]

total = 0.0
for token in tokenlist:
    try:
        token = int(token)
        total += token
    except ValueError:
        continue        
print(total)

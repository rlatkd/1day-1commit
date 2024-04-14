import sys
read = sys.stdin.readline

n = 1
Lst = [0] * 9

for _ in range(3):
    n *= int(read())
    
for i in str(n):
  Lst[(int(i))] += 1

for i in Lst:
  print(i)
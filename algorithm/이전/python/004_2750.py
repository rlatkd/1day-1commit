import sys
read = sys.stdin.readline

n = int(read())
lst = [int(read()) for _ in range(n)]

lst.sort()

for i in lst:
  print(i)
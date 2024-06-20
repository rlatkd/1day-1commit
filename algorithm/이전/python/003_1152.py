import sys
read = sys.stdin.readline

a = list(read().split())

cnt = 0
for i in a:
  cnt += 1

print(cnt)
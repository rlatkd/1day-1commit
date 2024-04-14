import sys
read = sys.stdin.readline

n = int(read())
num = list(map(int, read().split()))

num.sort()

print(num[0], num[n-1])
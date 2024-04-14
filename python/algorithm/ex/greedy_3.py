N = int(input())
X = list(map(int, input().split()))

X.sort()

people = 0
group_count = 0

for i in X:
  people += 1
  if people >= i:
    group_count += 1
    people = 0


print(group_count)
T = int(input())

X = [300, 60, 10]

A = []
count = 0

for i in X:
  count = T // i
  A.append(count)
  T = T % i
  
if 0 < T < 10:
 print(-1)
 del A
else:
  B = " ".join(map(str, A))
  print(B)
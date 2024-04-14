"""
n = 1260
count = 0

coin_types = [500, 100, 50, 10]

for coin in coin_types:
  count += n // coin
  n %= coin 
  
print(count)
"""

n = int(input())
k = int(input())
count = 0

while n != 1:
  if n % k == 0:
    n = n // k
  else:
    n = n - 1

  count += 1

print(count)
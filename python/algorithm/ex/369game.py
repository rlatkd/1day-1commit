# n개의 수를 받는다.
# n개의 수는 1, 2, 3, ... , n이 된다.
# 3의 배수면 박수를 친다.
# 숫자에 3의 배수가 들어가도 박수를 친다. 만약 343이면 2번 친다.
# 만약 33이면 3번 조건을 제외한다.(2번침)

n = int(input())

count = 0

for n in range(1, n+1):
  a = str(n).count('3') + str(n).count('6') + str(n).count('9')
  if n % 3 == 0:
    count += 1
    if a >= 2:
      count += a-1

  else:
    if a > 0:
      count += a

print(count)
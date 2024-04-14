S = input()

S_list = [int(char) for char in S]


result = S_list[0]

for i in S_list[1:]:
  if i == 0 or i == 1:
    result += i

  else:
    if result == 0:
      result += i
    else:
      result *= i

print(result)


import sys

N = sys.stdin.readline()

answer = int(N[0])

tmp_lst = []

for n in N[1:]:
  tmp_lst.append(answer+int(n))
  tmp_lst.append(answer*int(n))
  answer = max(tmp_lst)
  tmp_lst = []

print(answer)
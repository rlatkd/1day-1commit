S = input()

for x in 'abcdefghijklmnopqrstuvwxyz':
  print(S.find(x), end = ' ')

'''
word = list(map(str,input().rstrip()))

word_idx = []
new_idx = [-1] * 26


for i in word:
  word_idx.append(ord(i) - 96)
print(word_idx)

x = 0
for i in word_idx:
  new_idx[i-1] = x
  y = x - 1
  if y in [0,len(word_idx)]:
    if word_idx[x] == word_idx[x-1]:
      x = x-1
      
    else:
      x += 1
  else:
    x += 1
  
print(*new_idx)
'''
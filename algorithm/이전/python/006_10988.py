a = []
word = list(input().rstrip())
for i in word:
  a.append(i)
  
word.reverse()

if word == a:
   print(1)
else:
  print(0)
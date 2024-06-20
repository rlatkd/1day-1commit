x = input()
y = []
z = 0

for i in x:
  if i.isalpha():
    y.append(i)
  else:
    z += int(i)

y.sort()
y.append(str(z))

print(''.join(y))
ipt = input()

row = int(ipt[1])
column = int(ord(ipt[0]) - ord('a')) + 1

ways = [(-2, -1), (-2, 1), (-1, -2), (-1, 2), (1, -2), (1, 2), (2, -1), (2, 2)]

count = 0

for i in ways:
  new_row = row + i[0]
  new_column = column + i[1]
  if new_row >= 1 and new_row <= 8 and new_column >= 1 and new_column <= 8:
    count += 1

print(count)
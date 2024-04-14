N = int(input())
way = input().split()

x, y = 1, 1

way_how = ['L', 'R', 'U', 'D']

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for i in way:
  for j in range(len(way_how)):
    if i == way_how[j]:
      nx = x + dx[j]
      ny = y + dy[j]
      
      if nx<1 or ny<1 or nx>N or ny>N:
        continue
      x, y = nx, ny
      
print(x, y)
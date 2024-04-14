from bisect import bisect_left, bisect_right
import sys

read = sys.stdin.readline

n, x = map(int, read().split())
array = list(map(int, read().split()))

def cntNums(array, right_value, left_value):
  right_index = bisect_right(array, right_value)
  left_index = bisect_left(array, left_value)
  return right_index - left_index

cnt = cntNums(array, x, x)

if cnt == 0:
  print(-1)
else:
  print(cnt)
from time import time, localtime, struct_time, asctime, ctime, strftime, strptime
from datetime import datetime

now= localtime(time())

print(now.tm_year, '년')
print(asctime(now))     # stuct_time을 인자로 함
print(ctime(time()))        # time을 인자로 함
print(strftime('%H시 %M분 %S초', now))      # stuct_time을 인자로 함 / format화 된 문자를 출력
structTime = strptime('2023년 08월 30일 12시 10분 20초', '%Y년 %m월 %d일 %H시 %M분 %S초')       # format문자를 입력해서 struct_time형식으로 보여줌
print(structTime)


# 2023-08-30 13:00:25 -> 2023년 08월 30일 13시 00분 25초

bformat = '%Y-%m-%d %H:%M:%S'
aformat = '%Y년 %m월 %d일 %H시 %M분 %S초'

dt = datetime.strptime('2023-08-30 13:00:25', bformat)

print(dt.strftime(aformat))
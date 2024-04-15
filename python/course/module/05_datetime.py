from datetime import datetime
# from datetime.datetime import now [안 됨]
# from datetime import datetime.now [안 됨]

strtime = datetime.now().strftime('%Y년 %m월 %d일 %H시 %M분 %S초')

print(strtime)
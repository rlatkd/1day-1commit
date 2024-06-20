from datetime import datetime, timedelta

afterdatetime = datetime.now() + timedelta(days=100, seconds=0)
print(afterdatetime.strftime('%Y년 %m월 %d일'))
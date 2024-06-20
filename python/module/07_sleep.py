from thread import MyThread
from datetime import datetime
from time import sleep

myThread = MyThread()
myThread.daemon = True
myThread.start()

i = 0

while True:
    if i>= 10:
        break
    i += 1
    print(f'{i}번째 실행')
    sleep(1)
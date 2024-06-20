from threading import Thread
from datetime import datetime
from time import sleep

class MyThread(Thread):
    def run():
        while True:
            print(datetime.now().strftime('%H시 %m분 %S초'))
            sleep(1)
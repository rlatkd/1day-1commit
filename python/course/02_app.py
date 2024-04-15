from myclass import Person
from pickle import dump
import os.path

#filepath = os.path.join('data', 'data.dat')

try:
    p = [Person('홍길동', 20), Person('심청이', 16)]
    with open('./2023_8/0825_0831_Python/0830/data/data.txt', 'wb') as fp:
         for person in p:
             dump(person, fp)
             
    print('객체 저장이 완료되었습니다')
    
except Exception as e:
    print(e)
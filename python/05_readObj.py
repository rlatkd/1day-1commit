from myclass import Person
from pickle import load

persons = []

try:
    with open('./2023_8/0825_0831_Python/0830/data/data.txt', 'rb') as fp:
        while True:
            p = load(fp)
            persons.append(p)

except:
    print('모든 객체를 읽어 들였습니다')
    
finally:
    print(persons)
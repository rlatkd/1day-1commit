class Person:
    def __init__(self):
        print('Person 생성자 호출')
        
class Student(Person):
    def __init__(self):
        super().__init__()      # 자기의 상위 클래스(Person)의 생성자를 호출
        print('Student 생성자 호출')
        
# 상위 영역을 초기화하고 돌아와서 자기 영역을 초기화

s1 = Student()
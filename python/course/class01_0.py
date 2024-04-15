'''
a = 10
b = 3.14
c = 'KIM'
d = 'KIHEE'

print(type(a), id(a))
print(type(b), id(b))
print(type(c), id(c))
print(type(d), id(d))
'''

'''[0]
class Person:
    def __init__(self, name, age):
        print('생성자가 호출되었습니다')
        self._name = name
        self._age = age
    
    def showinfo(self):
        print(f'이름 : {self._name}')
        print(f'연령 : {self._age}')
    
    @property    
    def name(self):             # 인터페이스
        print('getter가 호출되었습니다.')
        return self._name
    
    @name.setter
    def name(self, value):      # 인터페이스
        print('setter가 호출되었습니다. 전달값 : ', value)
        self._name = value
        
    @property
    def age(self):
        print('getter가 호출되었습니다.')
        return self._age
    
    @age.setter
    def age(self, value):
        print('setter가 호출되었습니다. 전달값 : ', value)
        self._name = value

class Student(Person):
    def __init__(self, name, age, major):
        super().__init__(name, age)
        self.__major = major
        
    @property       # major는 상위 클래스에서 getter setter가 안 되어있으니 자기가 해야됨    
    def major(self):
        return self.__major
    
    @major.setter
    def major(self, value):
        self.__major = value
        
    def __str__(self):
        return f'이름 : {self._name}, 연령 : {self._age}, 직업 : {self.__major}'
'''

'''[6]
    # @staticmethod
    def showinfo():
        print('showinfo() Call')
    
    staticShowinfo = staticmethod(showinfo)
    
    @classmethod
    def classinfo(cls):
        print(cls)
    

s1 = Student('홍길동', 20, '도적')
Student.staticShowinfo()
Student.classinfo()
'''

'''[5]
class Employee:
    pass

print(isinstance(s1, Student))
print(isinstance(s1, Person))
print(isinstance(s1, object))
print(isinstance(s1, Employee))

e = Employee()
print(isinstance(e, object))        # 모든 class는 object를 상속받는다.
print(isinstance(e, Employee))
print(s1)
print(e)
'''

'''[4]
print(f'{s1.name}, {s1.age}, {s1.major}')
'''

'''
# __는 privateed해서 자기 범위에서만 접근 허용
# _는 protected해서 자식 범위까지 접근 허용
# 아예 외부 범위는 접근 허용 불가 / 허용하려면 getter(읽기), setter 해야됨
print(s1)
'''

'''[3]
p1 = Person('홍길동', 20)
p1.name = '이순신'
print(p1.name)
p1.showinfo
p1.age = 20
print(p1.age)
p1.showinfo
'''

'''[2]
# self.[__지워야됨]name / self.__age 마찬가지
p1 = Person('홍길동', 20)
p2 = Person('심청이', 10)
p1.major = '도적'
print(f'이름 : {p1.name}, 연령 : {p1.age}, 직업 : {p1.major}')
print(f'이름 : {p2.name}, 연령 : {p2.age}')
print(isinstance(p1,Person))
print(isinstance(p2,Person))
p1.showinfo()
p2.showinfo()
'''

'''[1]
p1 = Person('홍길동', 20)
p2 = Person('심청이', 10)
# p1.__name = '에디슨'       -> 접근허용안됨

# class를 통해서 객체 내부인지 외부인지를 생각해야함
# 캡슐화를 통해 정보의 은닉 가능(외부에서 접근허용x)
# 유지보수를 쉽게 하자는 목적
'''
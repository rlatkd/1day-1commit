class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    
    def __str__(self):
        return f'__str__ : 이름 : {self.name}, 연령 : {self.age}'
    
    def __repr__(self):
        return f"Person('{self.name}', {self.age})"

p = Person('홍길동', 20)
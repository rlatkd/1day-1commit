# __iter__() 메서드를 정의하는 이유
# for i in iterator객체
# 파이썬은 내부적으로 iterator객체.__iter__()를 호출하여
# iterator객체로 변환하여 수행

'''[0]
class Names:
    def __init__(self, *args):
        self.__values = args
        self.__current = 0
        self.__stop = len(args)
        
    def __iter__(self):
        return self
    
    def getItem(self, idx):
        if idx < 0 or idx >= self.__stop:
            raise Exception('한계 범위를 벗어난 인덱스입니다')
        return self.__values[idx]

    def __next__(self):
        if self.__current < self.__stop:
            self.__current += 1
            return self.__values[self.__current - 1]
        else:
            raise StopIteration
    
ns = Names('홍길동', '에디슨', '심청이')
'''

'''[2]
for name in ns:
    print(name)
print(ns.getItem(0))
'''

'''[1]
print(ns.__next__())
print(next(ns))
print(ns.__next__())
'''
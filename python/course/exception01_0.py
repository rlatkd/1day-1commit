'''[1]
print('hello python')
'''

'''[3]
from exception01_1 import MyError

a = 10
b = 0

try:
# 사용자 정의 예외 사용하는 이유
# try절을 수행 도중
# 다양한 예외가 발생할 가능성이 있으며
# 어떠한 예외가 발생이 된다 하더라도
# 하나의 예외로 반환하고자 할 때
    if b == 0:
        raise MyError('정수는 0으로 나눌 수 없습니다')
    c = a // b
    print(c)
    
except MyError as e:
    print(e)
    
finally:
    print('연산이 종료되었습니다')
'''

'''[0]
try:
    c = a // b
    print(c)
    raise Exception('고의적인 에러')
    
except ZeroDivisionError as e:      # try중에 발생한 에러를 e타입으로 받음
    print('에러가 발생하였습니다')

except NameError | TypeError as e:
    print(e)
    
except Exception as e:      
    print(e)

else:        #try중에 에러가 발생하지 않으면 수행X
    print('END')

finally:        #try중에 에러가 발생하건 말건 수행함
    print('END')
'''



'''[2]
c = 0
if b > 0:       # 매번 b>0을 확인해야 됨(상대적 방어)
    c = a // b
print(c)
'''
from exception01_1 import MyError

a = 20
b = 0

try:
    c = a // b
    print(c)
    
except Exception as e:
    raise MyError()

'''
except NameError | TypeError | Exception as e:
    raise MyError()

except TypeError as e:
    raise MyError()

except Exception as e:
    raise MyError()
'''
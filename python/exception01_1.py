class MyError(Exception):
    
    def __init__(self, msg = '알 수 없는 오류가 발생하였습니다'):
        super().__init__(msg)
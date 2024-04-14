def solution(n):
    
    x = ''

    while n >= 3:
        x += str(n % 3)
        n = n // 3
        
    x += str(n)
    answer = int(x, 3)
    
    return answer
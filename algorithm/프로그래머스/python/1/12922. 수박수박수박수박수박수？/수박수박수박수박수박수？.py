def solution(n):
    answer = '수박'
    
    if (n == 1):
        return answer[0]    
    
    elif (n % 2 == 0):
        return answer * int(n/2)
    
    else:
        N = n/2
        return (answer * int(N)) + (answer[0])
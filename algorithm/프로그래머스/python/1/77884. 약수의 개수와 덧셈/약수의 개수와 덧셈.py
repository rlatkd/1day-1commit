def solution(left, right):
    
    answer = 0
    
    for i in range(left, right + 1):
        sqr = i**(1/2)

        if int(sqr) == sqr:
            answer -= i
            
        else:
            answer += i

    return answer
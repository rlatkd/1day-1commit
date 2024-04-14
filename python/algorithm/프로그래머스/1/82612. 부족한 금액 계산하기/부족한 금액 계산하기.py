def solution(price, money, count):
    
    answer = price
    
    for i in range(2, count+1):
        answer += price * i
        
    return answer-money if answer-money >= 0 else 0
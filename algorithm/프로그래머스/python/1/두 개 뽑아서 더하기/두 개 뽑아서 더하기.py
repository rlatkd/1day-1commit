def solution(numbers):
    answer = []

    numbers = sorted(numbers)
    
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            answer.append(numbers[i] + numbers[j])
            
    answer = sorted(set(answer))
    return answer
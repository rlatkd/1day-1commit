def solution(answers):
    answer = []
    no_math = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    zero = [0,0,0]
    
    for i in range(len(no_math)):
        for j in range(len(answers)):
            n = len(no_math[i])
            if answers[j] == no_math[i][j%n]:
                zero[i] += 1
                
    for idx, score in enumerate(zero):
        if score == max(zero):
            answer.append(idx+1)
    
    return answer

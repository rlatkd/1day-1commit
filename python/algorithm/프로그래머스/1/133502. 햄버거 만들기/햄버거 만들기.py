def solution(ingredient):
    answer = 0
    curr = ""
    for i in range(len(ingredient)) :
        curr += str(ingredient[i])
        
        if len(curr) >= 4 and curr[len(curr) - 4: ] == "1231" :
            curr = curr[ : len(curr) - 4]
            answer += 1
            
    return answer
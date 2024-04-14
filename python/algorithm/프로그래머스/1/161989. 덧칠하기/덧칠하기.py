def solution(n, m, section):
    answer = 0
    
    n_painted = 0
    
    for i in section:
        if i > n_painted:
            n_painted = i + m -1
            answer += 1
    return answer
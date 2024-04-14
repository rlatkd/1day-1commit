def solution(sizes):
    
    max_width, max_height = 0, 0
    for a, b in sizes:
        if a > b:
            a, b = b, a
        max_width = max(max_width, a)
        max_height = max(max_height, b)
        
    answer = max_width * max_height
    return answer
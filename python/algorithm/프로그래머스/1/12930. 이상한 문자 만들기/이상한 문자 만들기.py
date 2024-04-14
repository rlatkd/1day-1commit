def solution(s):
    res = ""
    ans = []
    
    for w in s.split(' '):
        for i in range(len(w)):
            if i % 2 == 0:
                res += w[i].upper()
            else : 
                res += w[i].lower()
        ans.append(res)
        res = ""
        
    return ' '.join(ans)
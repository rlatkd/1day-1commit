def solution(X, Y):
    
    xy = set(X) & set(Y)
    
    if not xy:
        
        return "-1"
    if len(xy) == 1 and "0" in xy:
        return "0"
    
    else:
        return "".join([i * min(X.count(i), Y.count(i)) for i in sorted(xy, reverse=True)])
import numpy as np

def solution(friends, gifts):
    dic = {f:i for i, f in enumerate(friends)}
    table = [ [0] * len(friends) for _ in range(len(friends))]
    presents = [0] * len(friends)
    
    for gift in gifts:
        g, t = gift.split()
        table[dic[g]][dic[t]] += 1
    
    array = np.array(table)
    
    t_given = array.sum(axis = 1)
    t_taken = array.sum(axis = 0)
    jisu = list(t_given - t_taken)
    
    for i in range(len(friends)):
        for j in range(i+1, len(friends)):
            if table[i][j] > table[j][i]:
                presents[i] += 1
            elif table[j][i] > table[i][j]:
                presents[j] += 1
            else:
                if jisu[i] > jisu[j]:
                    presents[i] += 1
                if jisu[j] > jisu[i]:
                    presents[j] += 1

    return max(presents)
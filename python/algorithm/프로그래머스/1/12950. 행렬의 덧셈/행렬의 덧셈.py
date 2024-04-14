def solution(arr1, arr2):
    answer = [[a+b for a,b in zip(A, B)] for A, B in zip(arr1, arr2)]
    
    return answer
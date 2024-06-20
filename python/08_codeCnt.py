import os.path
import re

logFile = os.path.join('./2023_8/0825_0831_Python/0830', 'access.log.2017-10-13')
codeCounter = {}

try:
    with open(logFile, 'r') as fp:
        for line in fp:
            code = line.split(' ')[8]
            if code in codeCounter:
                codeCounter[code] += 1
                
            else:
                codeCounter[code] = 1
        
    sortedCounter = sorted(codeCounter.items(), key=lambda x: x[1], reverse=True)
    for s in sortedCounter:
        print(s)
       
except:
    print('예외가 발생하였습니다')
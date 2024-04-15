import os.path
import re

logFile = os.path.join('./2023_8/0825_0831_Python/0830', 'access.log.2017-10-13')
ipPattern = r'\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}'
ipCounter = {}

try:
    with open(logFile) as fp:
        logData = fp.read()
    ips = re.findall(ipPattern, logData)
    
    for ip in ips:
        if ip in ipCounter:
            ipCounter[ip] += 1
        else:
            ipCounter[ip] = 1
            
    sortedCounter = sorted(ipCounter.items(), key=lambda x: x[1], reverse=True )[:10]
    for info in sortedCounter:
        print(info)
       
except:
    print('예외가 발생하였습니다')
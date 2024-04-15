import os.path
import re
import openpyxl

# TODO
# sortedCounter의 값을 엑셀파일로 저장합니다.
# 헤더 : A1은 IP주소, B1은 요청수
# ......
# 총 요청건수       전체요청건수

logFile = os.path.join('.', 'access.log.2017-10-13')

ipPattern = r'\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}'
ipCounter = {}


try:
    with open(logFile, 'r') as fp:
        logData = fp.read()
    ips = re.findall(ipPattern, logData)

    for ip in ips:
        if ip in ipCounter:
            ipCounter[ip] += 1
            
        else:
            ipCounter[ip] = 1
            
    sortedCounter = sorted(ipCounter.items(), key=lambda x: x[1], reverse=True)
    #dicsortedCounter = [{item[0]:item[1]} for item in sortedCounter ]
    #print(sortedCounter)
    # headers = ['IP주소', '요청수']
    
    # excelFile = os.path.join('.', 'data.xlsx')
    # wb = openpyxl.load_workbook(excelFile)
    # ws = wb.active
    # ws.append(headers)

    # row = 2
    
    # for tp in sortedCounter:
    #     ws.append([value for key, value in tp.items()])
    #     ws.cell(row=row, column=3, value=f'=B{row}*C{row}')
    #     row += 1
    # ws.append(['총액', '', '', f'=SUM(C2:C{row-1})'])

    # wb.save(excelFile)
    # wb.close()
    
    
    
            
except Exception as e:
    print(e)
#[0]
try:
    with open('./2023_8/0825_0831_Python/0830/data/data.txt', 'w', encoding='utf-8') as fp:           
        fp.write('12331')
        

except Exception as e:     # except 뒤에 아무것도 안쓰면 (Exception이 default)
    print(e)
      
'''[1]
fp = open('./2023_8/0825_0831_Python/0830.data.txt', 'a', encoding='utf-8')       # fp 사용 (핸들링)
    subject = '파이썬'
    print(f'{subject}는 쉬운가요?', file=fp)
#fp.writelines('여기에 데이터를')
fp.close()
'''
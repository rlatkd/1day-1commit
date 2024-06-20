format = ('wav',)
sample = '44Hz'
bitrate = '128bps'

def waveout(file):
    print(f"waveout 출력: {file},{format},{sample},{bitrate}")

def waveout2(file):
    print(f"새로 생성된 함수입니다.")

if __name__ == '__main__':
    print("wave 모듈 실행")
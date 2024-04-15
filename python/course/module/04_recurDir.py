from os import walk
from os.path import isfile, getsize, abspath, join

dir = join('.')
files =walk(dir)

for root, dirs, files in files:     # root - 현재 디렉토리 / dirs - 현재 디렉토리 밑에 디렉토리 / files - 현재 디렉토리 밑에 파일들
    print(abspath(join(root)))      # 현재 디렉토리 표기
    for file in files:
        print(abspath(join(root, file)))        # 현재 디렉토리에 있는 파일들 표기
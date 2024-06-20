import os
import os.path

#[0]
dir = os.path.join('./2023_8/0825_0831_Python/0830/module','data')

try:
    os.mkdir(dir)

except:
    pass


'''[1]
if not os.path.exists(dir):
    os.mkdir(dir)
'''
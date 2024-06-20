import os

#[0]
line_num = 1
with os.popen('ls -l', 'r') as pp:
    for line in pp:
        print('{:>3} : {}'.format(line_num, line))
        line_num += 1

'''[1]
result = os.system('ls -l')
print(result)
'''
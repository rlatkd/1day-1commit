import os
import os.path

dir = os.path.join('.')

files = os.listdir(dir)

for file in files:
    current = os.path.join(dir, file)
    typename = 'FILE' if os.path.isfile(current) else 'DIR'
    size = str(os.path.getsize(current)) + 'B'
    abspath = os.path.abspath(current)
    print('{:<4} {:>10} {}'.format(typename, size, abspath))
    

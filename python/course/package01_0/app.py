'''[0]
from sound.effects.eco import delayout
from sound.formats.wave import waveout
from sound.formats import VERSION

delayout('music.mp3')
waveout('music.mp3')
print(VERSION)
'''
'''[1]
# from sound.formats.wave import *
# from sound.effects.echo.*
# print(sample)
# print(format)
# print(bitrate)
# waveout('date.mp3')

# delayout('date.mp3')
'''

# [2]
# import sound.formats.wave
# import sound.effects.echo
import sound

if __name__ == '__main__':
    sound.delayout('delay체크.mp3')
    sound.waveout('wave체크.mp3')
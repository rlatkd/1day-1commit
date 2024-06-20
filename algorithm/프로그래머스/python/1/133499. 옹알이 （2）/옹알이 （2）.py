import re
def solution(babbling):

    for i in range(len(babbling)):
        babbling[i] = babbling[i].replace('aya','1')
        babbling[i] = babbling[i].replace('ye','2')
        babbling[i] = babbling[i].replace('woo','3')
        babbling[i] = babbling[i].replace('ma','4')

    cnt = 0

    for babble in babbling:

        if re.findall('[a-z]',babble): continue

        elif '11' in babble or '22' in babble or '33' in babble or '44' in babble: continue

        else: cnt += 1
    return cnt
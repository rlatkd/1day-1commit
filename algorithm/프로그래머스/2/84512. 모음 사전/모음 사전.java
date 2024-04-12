import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        int total = 3905;  //전체 경우의 수(최댓값): 5+25+125+625+3125
        String alpha = "AEIOU";  //AEIOU 저장(대문자 순서 정해져있으므로)
        
        for (String str : word.split("")) {  //word에 담아온 문자열 하나씩 분리
            total /= 5;  //루프마다 /5
            answer += total*alpha.indexOf(str)+1;  //가중치, 인덱스1부터 시작하도록 +1
        }
        return answer;
    }
}
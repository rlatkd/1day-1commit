import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];  // price크기만큼 배열 선언
        
        for (int i=0; i<prices.length; i++) {
            for (int j=i+1; j<prices.length; j++) {  // 다음값과 비교
                answer[i]++;  // i번째 값 증가
                if (prices[i] > prices[j])  // 다음값 보다 크면 탈출
                    break;
            }
        }
        return answer;
    }
}
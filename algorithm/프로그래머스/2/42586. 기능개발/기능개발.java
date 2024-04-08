import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] endDay = new int[100];  //끝나는 날을 모아두는 배열을 선언     
        int day = -1;  //초기 day
        
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + day * speeds[i] < 100) {
                day++;  //100%미만이면 계속해서 day가 늘어남
            }
            endDay[day]++;  //day를 기준으로 완료된 작업 갯수를 저장
        }
        return Arrays.stream(endDay).filter(i -> i!=0).toArray();  //작업갯수가 0은 배제
    }
}
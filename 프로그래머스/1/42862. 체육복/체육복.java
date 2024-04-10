import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;  //체육수업 들을 수 있는 학생 수
        
        //lost, reserve 오름차순 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //여벌 체육복 있는 학생이 도난당한 경우
        for (int i=0; i<lost.length; i++) {
            for (int j=0; j<reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = reserve[j] = -1;  //둘다 초기화
                    break;
                }
            }
        }
        
        //여벌 체육복 있는 학생의 번호 -1,+1이 도난당한 학생일 경우
        for (int i=0; i<lost.length; i++) {
            for (int j=0; j<reserve.length; j++) {
                if (lost[i]==reserve[j]-1 || lost[i]==reserve[j]+1) {
                    answer++;
                    reserve[j] = -1;  //여벌학생만 초기화
                    break;
                }
            }
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {

        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();  //스코빌 지수 가장 낮은 음식부터 차례대로 계산하기 위해 우선순위큐 이용
        
        for (int sc : scoville)  //pq에 요소 다 넣음
            pq.offer(sc);
        
        while (pq.peek()<K) {  //스코빌 지수가 가장 낮은 음식이 K보다 낮을 때 반복
            int first = pq.poll();  //가장 맵지 않은 스코빌 지수
            int second = pq.poll();  //두 번째로 맵지 않은 스코빌 지수
            int sc = first + second * 2;  //섞은 음식 스코빌 지수
            
            pq.offer(sc);  //pq에 추가
            answer++;  //섞은 횟수 증가
            
            if (pq.peek()>=K)  //스코빌 지수가 가장 낮은 음식이 K이상일 때 탈출
                break;
            
            if (pq.size()==1 && pq.peek()<K) {  //남은 음식이 1개일 때
                answer=-1;
                break;
            }
        }
        return answer;
    }
}
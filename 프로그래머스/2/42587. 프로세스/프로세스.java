import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  // 우선순위큐 선언 및 내림차순 정렬
        
        for (int i : priorities)  // 배열에 있는 요소들 pq에 추가
            pq.offer(i);
        
        while (!pq.isEmpty()) {  // pq가 빌 때까지 반복
            for (int i=0; i<priorities.length; i++) {
                if (pq.peek()==priorities[i]) {  // 현재 위치 찾기
                    pq.poll();  // 첫번째 값 반환하고 제거
                    answer++;
                    
                    if (location==i)  // 현재위치가 location과 같으면 리턴
                        return answer;
                }
            }
        }
        return answer;
    }
}
/*
ABCD
2132 loc2 -> C
CDAB -> 0+1=1

ABCDEF
119111 loc0 -> A
CDEFAB -> 4+1=5
*/
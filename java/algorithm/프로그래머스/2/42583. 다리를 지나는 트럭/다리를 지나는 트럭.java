import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int curr_weight = 0;  // 현재 다리위의 트럭들 총 무게
        Queue<Integer> bridge = new LinkedList<>();  // 다리를 큐로 선언
        
        // 아무 트럭도 다리를 건너지 않은 상태(초기화)
        for (int i=0; i<bridge_length; i++) {
            bridge.add(0);
        }
        
        for (int new_weight : truck_weights) {  // 매 트럭마다 반복
            
            // 다리 위의 트럭 + 새로 들어온 트럭이 다리가 견딜 수 있는 무게보다 크면
            while (curr_weight+new_weight-bridge.peek() > weight) {
                
                // 가장 먼저 들어간 트럭 보내야됨
                curr_weight -= bridge.poll();  // 총 무게에서 가장 먼저 들어간 트럭 무게 뺌
                bridge.add(0);  // 마지막 자리에 새로운 초기화
                answer++;  // 시간 증가
            } 
            
            // while문 아니면
            curr_weight -= bridge.poll();  // 동일
            curr_weight += new_weight;  // 새 트럭 무게 더함
            bridge.add(new_weight);  // 새 트럭 추가
            answer++;  // 동일
        }
        return answer+bridge_length;  // 마지막 트럭은 다리 크기만큼 시간이 걸림
    }
}
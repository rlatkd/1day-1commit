import java.util.*;

class Solution {
    
    public long solution(int[] weights) {
        
        long answer = 0;
        
        // 정렬하여 무게를 오름차순으로 정렬
        Arrays.sort(weights);
        
        // 특정 무게에 대한 등장 횟수를 저장하기 위한 해시맵 생성
        HashMap<Double, Integer> map = new HashMap<>();

        // 각 무게에 대해 반복
        for(int w : weights) {
            
            double a = (double) w; // 현재 무게를 double형으로 변환하여 저장
            double b = ((double) w * 2.0) / 3.0; // 현재 무게의 2/3 값을 저장
            double c = (double) w / 2.0; // 현재 무게의 절반 값을 저장
            double d = ((double) w * 3.0) / 4.0; // 현재 무게의 3/4 값을 저장

            // map에 a가 존재하는 경우 answer에 해당 무게의 등장 횟수를 더함
            if(map.containsKey(a)) {
                answer += map.get(a);
            }
            
            // map에 b가 존재하는 경우 answer에 해당 무게의 등장 횟수를 더함
            if(map.containsKey(b)) {
                answer += map.get(b);
            }
            
            // map에 c가 존재하는 경우 answer에 해당 무게의 등장 횟수를 더함
            if(map.containsKey(c)) {
                answer += map.get(c);
            }
            
            // map에 d가 존재하는 경우 answer에 해당 무게의 등장 횟수를 더함
            if(map.containsKey(d)) {
                answer += map.get(d);
            }

            // 현재 무게 a의 등장 횟수를 1 증가시켜 map에 저장
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        return answer;
        
    }
    
}

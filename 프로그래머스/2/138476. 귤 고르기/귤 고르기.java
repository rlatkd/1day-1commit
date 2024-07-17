import java.util.*;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        
        int answer = 0;
        
         // 배열 정렬
        Arrays.sort(tangerine);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++) {
        	map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        // 탱자 종류
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        // 탱자 빈도 기준으로 내림차순
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        // 빈도가 높은 탱자부터 선택
        for (int i : keySet) {
        	k -= map.get(i);
        	answer++;
        	if(k <= 0) return answer;
        }
        
        return answer;
        
    }
    
}
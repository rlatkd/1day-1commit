import java.util.*;
  
class Solution {
  
    public int solution(int[] numbers, int target) {
        
        int answer = 0;
        int size = 0;
        int sum = 0;

        Queue<Integer> ll = new LinkedList<>();

        ll.add(0);
        
        for (int i = 0; i < numbers.length; i++) {
            size = ll.size();
            for (int j = 0; j < size; j++) {
                sum = ll.poll();
                ll.add(sum + numbers[i]);  
                ll.add(sum - numbers[i]);  
            }  
        }  
        while (!ll.isEmpty()) {  
            if (ll.poll() == target) {  
                answer++;  
            }  
        }  
        return answer;  
    }  
}
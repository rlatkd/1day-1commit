import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        //뽑을 수 있는 최대 폰켓몬 수
        int max = nums.length / 2;
        
        //중복 제거를 위해 HashSet 이용
        Set<Integer> hashSet = new HashSet<>();
        
        //중복 제거 하면서 HashSet에 추가
        for (int i : nums) {
            hashSet.add(i);
        }
        
        //HashSet 크기가 max보다 크면 max
        if (hashSet.size() > max)
            return max;
        else
            return hashSet.size(); //작으면 HashSet
    }
}
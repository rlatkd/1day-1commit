import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        //뽑을 수 있는 최대 폰켓몬 수
        int max = nums.length / 2;
        
        //중복 제거를 위해 HashSet이용
        Set<Integer> hashSet = new HashSet<>();
        
        //중복 제거 하면서 HashSet에 추가
        for (int i : nums) {
            hashSet.add(i);
        }
        
        //최대 폰켓몬이 HashSet 크기 이상이면
        if (max >= hashSet.size())
            return hashSet.size(); //HashSet 크기 반환
        else
            return max; //최대 폰켓몬 수 반환
    }
}
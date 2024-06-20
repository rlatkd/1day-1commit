import java.util.*;

class Solution {
    
    public int solution(int[][] targets) {
        
        //x기준 좌표 정렬
        Arrays.sort(targets, (a,b) -> a[0] -b[0]);
        
        int cnt = 0; //타겟을 커버하는 구간의 갯수
        int last = -1; //현재 구간의 끝 지점
        
        for (int[] target : targets) {
            
            //새로운 구간이 필요한 경우
            if (target[0] > last) {
                cnt++;
                last = target[1] - 1;
            }
            
            //현재 구간의 끝 지점 업데이트
            else if (target[1] - 1 < last) {
                last = target[1] - 1;
            }
            
        }
        
        return cnt;
        
    }
    
}
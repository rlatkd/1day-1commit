import java.util.*;

class Solution {
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Arrays.sort(data, 
                    Comparator
                    .comparingInt((int[] a) -> a[col - 1]) // col-1 번째 열의 값을 기준으로 오름차순 정렬
                    .thenComparingInt((int[] a) -> -a[0]) // 같은 값일 경우 첫 번째 열의 값을 기준으로 내림차순 정렬
                   );

        int answer = 0;
        
        // row_begin 부터 row_end 까지의 각 행에 대해 반복
        for (int i=row_begin; i<=row_end; i++) {
            int rowIndex = i;

           // 해당 행의 각 요소에 대해 row_index로 나눈 나머지의 합을 구한 후 XOR 연산
            answer ^= Arrays.stream(data[rowIndex-1]) // 
                .map(it -> it % rowIndex)
                .reduce(0, (a, b) -> a + b);
        }

        return answer;
        
    }
    
}

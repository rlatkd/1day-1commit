import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];  //3칸의 Array 생성
        
        for (int i = 0; i < commands.length; i++) {
            
            //Arrays.copyOfRange(복사할 배열, 시작 인덱스, 끝 인덱스)
            int [] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);  //오름차순 정렬
            
            answer[i] = temp[commands[i][2] - 1];  //n번째 숫자 answer에 넣기
        }
        return answer;
    }
}
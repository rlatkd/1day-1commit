import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        //원소가 몇개 들어갈지 모르니 ArrayList 선언
        List<Integer> answerList = new ArrayList<>();
        
        //초기화
        int value = -1;
        
        //루프 돌면서 arr의 원소를 answerList에 넣음
        for (int i=0; i<arr.length; i++) {
            if (value != arr[i]) {
                answerList.add(arr[i]);
                value = arr[i]; //value에 재할당
            }
        }
        
        //answerList를 answer라는 Array로 변환
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size();i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
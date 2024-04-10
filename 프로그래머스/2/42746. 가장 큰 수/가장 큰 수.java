import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        String[] stringArray = new String[numbers.length];  //String Array 선언
        
        for (int i=0; i<numbers.length; i++)
            stringArray[i] = String.valueOf(numbers[i]);  //numbers의 요소들을 문자로 변환하여 stringArray에 담음
        
        //compateTo 비교연산
        //3031, 3130 -> 3130
        Arrays.sort(stringArray, (A,B) -> (B+A).compareTo(A+B));
        
        if (stringArray[0].equals("0"))  //모든 숫자가 0일 때 리턴
            return stringArray[0];
        
        StringBuilder stringBuilder = new StringBuilder();  //문자열 합치기용 StringBuilder 이용
        
        for (String string : stringArray)
            stringBuilder.append(string);
            
        return stringBuilder.toString();  //문자열로 반환하기 위해선 toString 명시
    }
}
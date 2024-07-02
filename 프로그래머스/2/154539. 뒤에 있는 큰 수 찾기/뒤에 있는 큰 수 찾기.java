import java.util.Stack;
import java.util.Arrays;

class Solution {
    
    public int[] solution(int[] numbers) {
        
        Stack<Integer> stack = new Stack<Integer>();

        //-1로 원소 채우기
        int[] result = new int[numbers.length];
        Arrays.fill(result, -1);
       

        //뒤에서부터 검사
        for (int i=numbers.length-1; i>-1; i--) {

            // stack이 비어있지 않고 현재 숫자가 맨 위 원소 이상이면
            while (!stack.empty() && numbers[i] >= stack.peek()) {
                stack.pop();
            }

            //stack이 비어있지 않은 경우
            if (!stack.empty()) {
                result[i] = stack.peek();
            }

            //stack에 현재 숫자 추가
            stack.push(numbers[i]);
        }

        return result;
        
    }
    
}
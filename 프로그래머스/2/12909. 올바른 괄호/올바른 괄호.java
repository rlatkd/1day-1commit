import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();  // 문자 스택
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)=='(')  // (가 들어갈 자리면
                stack.push('(');   // 스택에 추가
            else {
                if (stack.isEmpty())  // 스택이 비어있으면
                    return false;     // false 반환; 이거 없을시 빈 스택이라 예외처리됨
                else              // (가 들어갈 자린데 )가 있으면
                    stack.pop();  // 스택에서 제거
            }
        }
        answer = stack.isEmpty() ? true : false;
        
        return answer;
    }
}
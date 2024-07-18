import java.util.*;

class Solution {
    
    public List<Integer> getDiv(int a) {
        
        List<Integer> arr = new ArrayList<>();
        
        // 숫자의 제곱근까지 반복
        for(int i=1; i<=Math.sqrt(a); i++) {
            if(a % i == 0) {
                arr.add(i);
                arr.add(a / i);
            }
        }
        return arr; // 약수 리스트
    }
    
    // 최대공약수
    public int problem(int[] arr1, int[] arr2) {
        List<Integer> div = getDiv(arr1[0]);
        Collections.sort(div, Collections.reverseOrder()); // 내림차순
        int i, j;
        boolean GCD; // 최대공약수?
        for (i=0; i<div.size()-1; i++) {
            GCD = false; // 초기화
            int num = div.get(i); //현재 숫자
            for(j = 0; j < arr1.length; j++) {
                if(arr1[j] % num != 0)
                {
                    break;
                }
            }
            if (j==arr1.length)
            {
                GCD = true;                
            }
            if (GCD) { // 최대공약수일 때
                for (j=0; j<arr2.length; j++) {
                    if(arr2[j] % num == 0)
                    {
                        break;
                    }
                }
                if(j == arr2.length)
                    return num;
            }
        }
        return 0;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int 철수;
        int 영희;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        // 각자의 최대공약수
        철수 = problem(arrayA, arrayB);
        영희 = problem(arrayB, arrayA);
        answer = 철수 > 영희 ? 철수 : 영희;
        return answer;
    }
    
}
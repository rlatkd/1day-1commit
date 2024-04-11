import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];  //가로 격자수, 세로 격자수
        int carpet = brown + yellow;  //카펫의 총 격자수는 brown+yellow
        
        for (int i=3; i<carpet; i++) {  //카펫이 만들어지기 위해선 격자가 최소 3개 이상이어야함
            
            //가로 격자수x세로 격자수 = 총 격자수
            //{i,j}는 총 격자수의 약수
            int j = carpet / i;
            
            if (carpet%i==0 && j>=3) {  //약수이기 위해선 나머지가 없어야되고 최소 3개 이상의 격자를 갖고 있어야함
                int col = Math.max(i,j);  //가로
                int row = Math.min(i,j);  //세로
                
                int center = (col-2) * (row-2);  //중앙 격자는 각각 총 가로와 세로의 -2 칸임
                
                if (center == yellow)  {   //이렇게 구한 값이 yellow라면 정답
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}
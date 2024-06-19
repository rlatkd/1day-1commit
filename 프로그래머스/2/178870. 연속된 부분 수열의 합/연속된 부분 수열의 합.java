class Solution {
    
    public int[] solution(int[] sequence, int k) {
        
        int[] answer = {-1,-1};
        int start=0;
        int end, num=0;

        for(int i=0;i<sequence.length;i++){
            
            end=i;
            num+=sequence[end];

            while(num>k){
                num-=sequence[start++];
            }

            if(num==k){
                if((answer[0]==-1 && answer[1]==-1) || end-start<answer[1]-answer[0]){
                    answer[0]=start;
                    answer[1]=end;
                }
            }
        }

        return answer;
        
    }
    
}
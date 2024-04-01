import java.util.HashMap;
import java.util.Map;

class Solution {
    //phone_book은 String Array임
    public boolean solution(String[] phone_book) {
        //HashMap선언
        Map<String,Integer> map = new HashMap<>();
        
        //key에 데이터를 넣은 이유; containsKey로 찾으려고
        for (int i=0;i<phone_book.length;i++) {
                map.put(phone_book[i],i);
        }
        
        //첫번째 119의 1, 11, 119를 HashMap안에 있는 데이터와 비교
        //...반복
        for (int i=0;i<phone_book.length;i++) {
                for (int j=0;j<phone_book[i].length();j++) {
                    if (map.containsKey(phone_book[i].substring(0,j)))
                        return false;
                    
            }
        }
        return true;
    }
}
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {

        //마라톤 참여한 선수들 participant
        //완주한 선수들 completion

        //완주하지 못한 선수들
        String nonCompletion = "";

        //map을 이용하여 <선수이름, 횟수>
        //참여자이면 횟수 + 1
        //완주했으면 횟수 - 1
        //그럼 완주 못 했으면 횟수가 0이 아니겠네
        Map<String, Integer> hashMap = new HashMap<>();
        
        //getOrDefault: 찾는 키 존재하면 키 반환 | 없다면 default값 반환
        for (String player : participant)
            hashMap.put(player, hashMap.getOrDefault(player, 0) + 1);
        
        //완주했으면 해당하는 선수의 value를 - 1 해서 0으로 만들면됨
        for (String player : completion)
            hashMap.put(player, hashMap.get(player) - 1);


        for (String player : hashMap.keySet()) {
            if (hashMap.get(player) != 0)  //선수의 value가 0이 아니면 완주 못 한 사람
                nonCompletion = player;
        }
        return nonCompletion;
    }
}
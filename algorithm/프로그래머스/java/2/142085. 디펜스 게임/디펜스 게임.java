import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        int result = 0;

        // 무적권을 소모한 라운드 정보
		PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        // 1라운드에 무적권 사용(무적권 1번 이상)
		queue.add(enemy[0]);
		k--;
		result++;
        
		// 무적권을 사용할 수 있으면 무적권을 사용
		for (int i = 1; i < enemy.length; i++) {
			if (k > 0) {
				queue.add(enemy[i]);
				k--;
			} else { // 무적권을 사용할 수 없다면
                // 현재 라운드의 적 수 > 무적권을 소모한 라운드의 적 수인 경우 스왑
				int tmp = queue.poll();
				if (enemy[i] > tmp) {
					queue.add(enemy[i]);
					n-=tmp;
				} else {
					queue.add(tmp);
					n-=enemy[i];
				}
			}

			if (n < 0) // 현재 라운드를 버티지 못한 경우
				return result;
			result++; // 현재 라운드를 버틴 경우
		}

		return result;
        
    }
}
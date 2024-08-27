import java.util.*;

public class Main {
    private static int MAX = 100001;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] check = new int[MAX];
        Arrays.fill(check, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        check[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current==K) {
                System.out.println(check[current]);
                break;
            }

            int[] nextStates = {current - 1, current + 1, 2 * current}; // 이동 가능한 상태들

            for (int nextState : nextStates) {
                if (nextState>=0 && nextState<MAX && check[nextState]==-1) {
                    queue.add(nextState);
                    check[nextState] = check[current] + 1; // 현재까지의 시간에 1초 추가
                }
            }
        }
    }
}
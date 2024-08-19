import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static Map<Integer, Integer> map = new HashMap<>();
    static boolean[] visited = new boolean[101];

    static class Info {
        
        int cnt;
        int idx;

        public Info(int cnt, int idx) {
            this.cnt = cnt;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(0, 1));

        while(!queue.isEmpty()) {
            Info info = queue.poll();

            // 주사위 1~6까지 던지기
            for (int i = 1; i <= 6; i++) {
                int cur = info.idx + i;
                
                // 100이면 도착
                if (cur == 100) {
                    return info.cnt + 1;
                }
                // 100 보다 크다면 아무것도 하지 않음
                if (cur > 100) {
                    continue;
                }
                // 이미 방문한 숫자라면 넘어감(중복 제거)
                if (visited[cur]) {
                    continue;
                }
                
                Integer num = map.getOrDefault(cur, 0);
                
                // 사다리, 뱀 확인
                if (num == 0) {
                    queue.offer(new Info(info.cnt + 1, cur));
                    visited[cur] = true;
                } else {
                    queue.offer(new Info(info.cnt + 1, num));
                    visited[num] = true;
                }
            }
        }
        
        return -1;
    }
    
}
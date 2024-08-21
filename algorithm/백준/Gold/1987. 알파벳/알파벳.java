import java.io.*;
import java.util.*;

public class Main {
    
    static int R; // 행의 수
    static int C; // 열의 수
    static char[][] map;
    static boolean[] visit = new boolean[26];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int result = 0; // 최대 이동 거리

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        
        // 시작점 알파벳 방문 처리
        visit[map[0][0] - 'A'] = true;
        dfs(1, 0, 0);
        System.out.println(result);
        
    }

    // dfs
    static void dfs(int cnt, int x, int y) {
        if(cnt == R * C) { // 모든 칸을 다 방문한 경우
            result = Math.max(cnt, result);
            return;
        }
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx<0 || ny<0 || nx>=C || ny>=R) continue;
            
            char na = map[ny][nx];

            if(visit[na - 'A']) { // 이미 방문한 알파벳인 경우
                result = Math.max(cnt, result);
                continue;
            }

            visit[na - 'A'] = true;
            dfs(cnt + 1, nx, ny);
            visit[na - 'A'] = false;
        }
    }
}

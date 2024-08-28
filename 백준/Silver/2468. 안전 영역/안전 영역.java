import java.io.*;
import java.util.*;

public class Main {
    static int N,result, count, nx, ny;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Integer> heights = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (!heights.contains(graph[i][j])) { // 건물 높이 리스트
                    heights.add(graph[i][j]);
                }
            }
        }

        result = 1;
        
        for (Integer height : heights) {
            count = 0;
            visited = new boolean[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (!visited[i][j] && graph[i][j] >= height) {
                        count++;
                        dfs(height, i, j);
                    }
                }
            }
            result = Math.max(result, count);
        }
        System.out.println(result);
    }

    // dfs
    static void dfs(int height, int x, int y) {
        visited[x][y] = true;
        for (int i=0; i<4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx>=0 && ny>=0 && nx<N && ny<N) {
                if (!visited[nx][ny]) {
                    if (graph[nx][ny] >= height) { // 해당 건물 > 물의 높이
                        dfs(height, nx, ny);
                    }
                }
            }
        }
    }
}
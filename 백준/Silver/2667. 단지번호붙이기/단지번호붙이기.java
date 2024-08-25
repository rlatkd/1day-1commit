import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static boolean visited[][];
    static int N;
    static int count = 1;
    static int x[] = {-1, 1, 0, 0};
    static int y[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for (int i=0; i<N; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        visited = new boolean[N][N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j]==1 && !visited[i][j]) { // 집이 있으면서 방문하지 않은 곳
                    dfs(i, j); // 연결 되어있는 단지 탐색
                    count++; // 다음 단지 수로 이동
                }
            }
        }

        System.out.println(count-1); // 총 단지 수
        int result[] = new int[count]; // 단지 내 집의 수
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (map[i][j] != 0)
                    result[map[i][j]]++;
            }
        }
        
        Arrays.sort(result);
        for (int i=1; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }
    
    // dfs
    public static void dfs(int i, int j) {
        map[i][j] = count;
        visited[i][j] = true;

        for (int k=0; k<x.length; k++) {
            int ix = i + x[k];
            int jy = j + y[k];

            if (ix>=0 && ix<N && jy>=0 && jy<N) {
                if (map[ix][jy]==1 && !visited[ix][jy]) { // 집이 있으면서 방문하지 않은 곳
                    dfs(ix, jy); // 연결 되어있는 단지 탐색
                }
            }
        }
    }
}
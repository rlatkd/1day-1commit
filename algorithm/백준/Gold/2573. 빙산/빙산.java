import java.util.*;
import java.io.*;

class Main {
    static int row;
    static int col;
    static int[][] map;
    static int[][] visited;
    static int[][] melt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        
        map = new int[row][col];
        visited = new int[row][col];
        melt = new int[row][col];

        for (int i=0; i<row; i++) { // 빙산 배열
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer();
    }
 
    static void answer() {
        int year = 0;
        while (true) {
            int count = 0;
            for (int i=0; i<row; i++) {
                for (int j=0; j<col; j++) {
                    if(visited[i][j] == 0 && map[i][j] != 0) { // 방문하지 않았고 빙산이 있는 경우
                        dfs(i, j);
                        count++;
                    }
                }
            }

            // 빙산이 모두 녹은 경우
            if (count == 0) {
                System.out.println(0);
                break;
            } else if (count >= 2) { // 빙산 덩어리가 2개 이상인 경우
                System.out.println(year);
                break;
            }

            melting();
            year++;
        }
    }

    // dfs
    static void dfs(int x, int y) {
        visited[x][y] = 1;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0<=nx && nx<row && 0<=ny && ny<col) { // 1년 후에 녹는 빙산의 양
                if(map[nx][ny] == 0)
                    melt[x][y]++;
                if (visited[nx][ny]==0 && map[nx][ny]!=0) // 방문하지 않았고 빙산이 있는 경우
                    dfs(nx, ny);                    
            }
        }
    }

    // 빙산 녹임
    static void melting() {
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                map[i][j] -= melt[i][j]; // 빙산 높이에서 녹은 양 뺌
                if(map[i][j] < 0)
                    map[i][j] = 0; // 높이가 음수가 되면 0으로 설정
                visited[i][j] = 0;
                melt[i][j] = 0;
            }
        }
    }
}

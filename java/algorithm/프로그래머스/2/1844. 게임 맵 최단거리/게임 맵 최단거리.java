import java.util.*;

class Solution {
    // 좌표이동에 사용되는 배열
    int[] dx = {0,0,1,-1};
    int[] dy = {-1,1,0,0};
    
    // BFS
    public void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> ll = new LinkedList<>();
        ll.add(new int[]{0,0,1}); // 출발 지점의 좌표와 경로를 길이와 함께 저장
        
        while (!ll.isEmpty()) {
            int[] curr = ll.poll();
            int x = curr[0];
            int y = curr[1];
            int length = curr[2]; // 현재 위치까지의 경로 길이
            
            // 4방향으로 이동하면서 탐색
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵 범위 안에 있음 & 이동 가능 & 아직 방문X
                if (nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length && visited[nx][ny]==0 && maps[nx][ny]==1) {
                    visited[nx][ny] = visited[x][y] + 1; // 현재 위치까지의 경로 길이에서 1을 더해 갱신
                    ll.add(new int[]{nx,ny,length+1}); // 다음 위치와 경로 길이를 추가
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length]; // 방문 여부 저장
        visited[0][0] = 1;
        
        bfs(maps,visited);
        
        answer = visited[maps.length-1][maps[0].length-1]; // 도착 지점까지의 최단 경로길이
        
        if (answer==0) // 도착지점 못 갈때
            answer = -1;

        return answer;
    }
}
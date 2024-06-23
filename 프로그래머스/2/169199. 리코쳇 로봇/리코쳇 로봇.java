import java.util.*;

//좌표
class Point{
    
    int x;
    int y;
    
    Point(int a, int b) {
        x = a;
        y = b;
    }
    
}

class Solution {
    
    int N, M;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int solution(String[] board) {
        
        N = board.length;
        M = board[0].length();
        int[][] visit = new int[N][M];
        Queue<Point> q = new ArrayDeque();
        
        //출발점의 좌표를 찾음
        for (int i=0; i<N; ++i) {
            String s = board[i];
            for(int j = 0 ; j < M; ++j){
                if(s.charAt(j) == 'R'){
                    q.add(new Point(i,j));
                    visit[i][j] = 1;
                    break;
                }
            }
        }
        
        //도착지점에 도달하지 못한다면 -1을 반환
        int answer = -1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            //if 현재 지점 == 도착지점
            if (board[cur.x].charAt(cur.y) == 'G') {
                answer = visit[cur.x][cur.y] - 1;
                break;
            }
            
            //4가지 방향으로 탐색
            for (int d=0; d<4; ++d) {
                int nextX = cur.x + dx[d];
                int nextY = cur.y + dy[d];
                while (true) { //해당 방향으로 최대한 끝까지 이동
                    if (isInRange(nextX, nextY) && board[nextX].charAt(nextY) != 'D') {
                        nextX += dx[d];
                        nextY += dy[d];
                    } else {
                    	//현재 지점은 보드 밖이거나, 장애물이 있는 지점
                        //직전의 좌표가 이동할 수 있는 좌표
                        nextX -= dx[d];
                        nextY -= dy[d];
                        break;
                    }
                }
                
                //해당 지점에 방문한적이 없다면, 해당 지점에서 탐색
                if (visit[nextX][nextY] == 0) {
                    q.add(new Point(nextX, nextY));
                    visit[nextX][nextY] = visit[cur.x][cur.y] + 1;
                }
            }
        }
        
        return answer;
        
    }
    
    public boolean isInRange(int x, int y) {
        if(0<=x && x<N && 0<=y && y<M)
            return true;
        return false;
    }
    
}
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static List<Node> house;
	static List<Node> chicken;
	static int answer;
	static boolean[] remaining;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		map = new int[N][N];

        for (int i=0; i<N; i++) { // map과 치킨집, 집의 리스트 저장
            st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					house.add(new Node(i, j));
				}
				if (map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
        }

		answer = Integer.MAX_VALUE;
		remaining = new boolean[chicken.size()];
		dfs(0, 0);
		bw.write(answer + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    // dfs
	public static void dfs(int start, int count){
		if (count == M) {
			int result = 0;
			for (int i=0; i<house.size(); i++) {
				int tmp = Integer.MAX_VALUE;
				for (int j=0; j<chicken.size(); j++) {
					if (remaining[j]) {
						int distance = Math.abs(house.get(i).x - chicken.get(j).x) 
						+ Math.abs(house.get(i).y - chicken.get(j).y);
						tmp = Math.min(tmp, distance);
					}
				}
				result += tmp;
			}
			answer = Math.min(answer, result);
			return;
		}

        // backtracking
		for (int i=start; i<chicken.size(); i++) {
			remaining[i] = true;
			dfs(i+1, count+1);
			remaining[i] = false;
		}
	}

}

// 노드
class Node{
	int x;
	int y;
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
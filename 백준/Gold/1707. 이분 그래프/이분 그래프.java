import java.util.*;

public class Main {
    
    static int K; // 테스트 케이스 수
    static int V; // 정점의 수
    static int E; // 간선의 수
    static String answer;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] set;

    public static void main(String[] args) {
        
        int p1, p2; // 두 정점; 간선
        Scanner scan = new Scanner(System.in);
        K = scan.nextInt();
        
        while (K-- > 0) {
            answer = "YES";
            V = scan.nextInt(); // 정점
            E = scan.nextInt(); // 간선
            graph = new ArrayList<>();
        
            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }
            
            for (int i = 0; i < E; i++) {
                p1 = scan.nextInt() - 1;
                p2 = scan.nextInt() - 1;
                
                // 양방향 간선 추가
                graph.get(p1).add(p2);
                graph.get(p2).add(p1);
            }
            
            set = new int[V];
            
            for (int i = 0; i < V; i++) {
                if (set[i] == 0) {
                    if (!bfs(i)) break;
                }
            }
            System.out.println(answer);
        }
        
    }
    
    // bfs
    public static boolean bfs(int n) {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(n);
        set[n] = 1;
        
        while (!queue.isEmpty()) {
            n = queue.poll();
            for (Integer i : graph.get(n)) {
                if (set[n] == set[i]) {
                    answer = "NO";
                    return false;
                }
                if (set[i] == 0) {
                    set[i] = set[n] * -1;
                    queue.add(i);
                }
            }
        }
        
        return true;
    }    
}

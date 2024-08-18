import java.io.*;
import java.util.*;

public class Main {
    
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();	// 트리 정보 저장 리스트
    static int answer = 0; // 리프 노드 개수 변수
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); // 노드의 개수 입력값
        int root = 0; //루트 노드 기본값
        
        //트리에 대한 ArrayList
        for (int i=0; i<=N; i++)
            tree.add(new ArrayList<>());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        // 트리정보
        for (int i=0; i<N; i++) {
            int node = Integer.parseInt(st.nextToken());
            if(node == -1){ // 루트 노드
                root = i;
                continue;
            }
            tree.get(node).add(i); // 일반 노드
        }
        
        // 삭제할 노드
        int remove = Integer.parseInt(br.readLine());
        
        if (remove == root)
            answer = 0;		// 트리가 없으면 리프 노드도 0개
        else // 루트 노드가 아닌 다른 노드 삭제시
            search(remove, root);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
    
    // dfs
    static void search(int remove, int node){
        
        // 현재 노드의 삭제할 노드 포함시 삭제
        if(tree.get(node).contains(remove))
            tree.get(node).remove(Integer.valueOf(remove));
 
        // 현재 노드가 리프 노드일 때
        if(tree.get(node).isEmpty()){
            answer++;
            return;
        }
        
        // 자식 노드가 존재할 때
        for(int next : tree.get(node)){
            search(remove, next);
        }
    }
    
}
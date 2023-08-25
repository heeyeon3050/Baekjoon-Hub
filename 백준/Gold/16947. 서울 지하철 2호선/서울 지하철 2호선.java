import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static boolean[] cycle;
    static int[] ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visit = new boolean[N + 1];
        cycle = new boolean[N + 1];

        // Cycle 여부 확인 수행
        for(int i = 1; i <= N; i++){
            if(isCycle(i, -1, i)){ //싸이클이 있다면 멈춤
                break;

            } else {
                Arrays.fill(visit, false);
            }
        }

        // 모든 정점에서 Cycle 사이의 거리를 구한다.(BFS 활용!)
        ans = new int[N +1];
        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    // cycle과 각 정점 사이의 거리를 계산하는 코드
    private static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(visit, false);
        for(int i = 1; i <= N; i++){
            if(cycle[i]) {
                visit[i] = true;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : graph[u]){
                if(!visit[v]){
                    q.offer(v);
                    visit[v] = true;
                    ans[v] = ans[u]+1;
                }
            }
        }
    }

    private static boolean isCycle(int u, int parent, int start){
        visit[u] = true;
        for(int v : graph[u]){
            if(!visit[v]){
                if(isCycle(v, u, start)){
                    cycle[v] = true;
                    return true;
                }
            } else if(v != parent && v == start){
                cycle[v] = true;
                return true;
            }
        }
        return false;
    }
}
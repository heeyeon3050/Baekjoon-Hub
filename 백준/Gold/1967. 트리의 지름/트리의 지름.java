import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node{
    int e;
    int cost;

    Node(int e, int cost){
        this.e = e;
        this.cost = cost;
    }
}

public class Main {
    static List<Node>[] list;
    static boolean[] visit;
    static int max = 0;
    static int node = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println(0);
            return;
        }

        list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[child].add(new Node(parent, cost));
            list[parent].add(new Node(child, cost));
        }

        visit = new boolean[n+1];
        dfs(1, 0);

        visit = new boolean[n+1];
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int len){
        if(len > max){
            max = len;
            node = x;
        }

        visit[x] = true;

        for(int i=0; i<list[x].size(); i++){
            Node n = list[x].get(i);

            if(!visit[n.e]){
                dfs(n.e, len+n.cost);
            }
        }
    }
}
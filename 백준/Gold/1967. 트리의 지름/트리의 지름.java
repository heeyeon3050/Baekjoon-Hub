import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Edge{
		int to;
		int cost;

		Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
	}

	static List<Edge>[] list;
	static boolean[] visit;
	static int max = 0;
	static int node = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		list = new List[n+1];
		for(int i=0; i<=n; i++){
			list[i] = new ArrayList<>();
		}

		for(int i=0; i<n-1; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Edge(b, c));
			list[b].add(new Edge(a, c));
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

		for(Edge e: list[x]){
			if(!visit[e.to]){
				dfs(e.to, len+e.cost);
			}
		}
	}
}
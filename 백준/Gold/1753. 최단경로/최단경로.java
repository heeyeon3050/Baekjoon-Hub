import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	static int[] dist;
	static List<Edge>[] adjList;

	public static class Edge implements Comparable<Edge>{
		int to;
		int cost;

		public Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(cost, o.cost);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new List[V+1];

		for(int i=0; i<=V; i++){
			adjList[i] = new ArrayList<>();
		}

		dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		K = Integer.parseInt(br.readLine());
		for(int i=0; i<E; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[u].add(new Edge(v, w));
		}

		dijkstra(K);

		for(int i=1; i<=V; i++){
			if(dist[i] == Integer.MAX_VALUE)
				sb.append("INF" + "\n");
			else
				sb.append(dist[i] + "\n");
		}

		System.out.println(sb);
	}

	private static void dijkstra(int num){
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] visit = new boolean[V+1];
		queue.offer(new Edge(num, 0));

		dist[num] = 0;

		while(!queue.isEmpty()){
			Edge edge = queue.poll();
			int cur = edge.to;

			if(visit[cur]) continue;

			visit[cur] = true;

			for(Edge e : adjList[cur]){
				if(!visit[e.to] && dist[e.to] > dist[cur] + e.cost){
					dist[e.to] = dist[cur] + e.cost;
					queue.offer(new Edge(e.to, dist[e.to]));
				}
			}
		}
	}
}
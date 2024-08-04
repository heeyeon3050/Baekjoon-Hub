import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static class Edge implements Comparable<Edge>{
		int to, cost;

		public Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o){
			return Integer.compare(cost, o.cost);
		}
	}

	static int v, e, k;
	static int[] dist;
	static List<Edge>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		list = new List[v+1];
		for(int i=0; i<=v; i++){
			list[i] = new ArrayList<>();
		}

		dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		k = Integer.parseInt(br.readLine());
		for(int i=0; i<e; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[u].add(new Edge(v, w));
		}

		dijkstra(k);

		for(int i=1; i<=v; i++){
			if(dist[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}

		System.out.println(sb);
	}

	public static void dijkstra(int num){
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[v+1];
		pq.offer(new Edge(num, 0));

		dist[num] = 0;

		while(!pq.isEmpty()){
			Edge edge = pq.poll();
			int now = edge.to;

			if(visit[now])
				continue;

			visit[now] = true;

			for(Edge e: list[now]){
				if(!visit[e.to] && dist[e.to] > dist[now] + e.cost){
					dist[e.to] = dist[now] + e.cost;
					pq.offer(new Edge(e.to, dist[e.to]));
				}
			}
		}
	}
}
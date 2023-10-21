import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] dist;
	static List<Edge>[] adjList;

	static class Edge implements Comparable<Edge>{
		int to, cost;

		private Edge(int to, int cost){
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
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		adjList = new List[N+1];
		for(int i=0; i<=N; i++){
			adjList[i] = new ArrayList<>();
		}

		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList[a].add(new Edge(b, c));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);

		System.out.println(dist[end]);
	}

	private static void dijkstra(int num){
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		boolean[] visit = new boolean[N+1];
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
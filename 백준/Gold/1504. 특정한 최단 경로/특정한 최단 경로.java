import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int n, e;
	static List<Node>[] list;

	public static class Node implements Comparable<Node>{
		int to, value;

		public Node(int to, int value){
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Node o){
			return Integer.compare(this.value, o.value);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		list = new ArrayList[n+1];
		for(int i=0; i<=n; i++){
			list[i] = new ArrayList<>();
		}

		for(int i=0; i<e; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, value));
			list[to].add(new Node(from, value));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int result1 = INF;
		int[] dist1 = dijkstra(v1); //양방향이기 때문에 가능
		int[] dist2 = dijkstra(v2);
		if(dist1[1] != INF && dist1[v2] != INF && dist2[n] != INF) {
			result1 = dist1[1] + dist1[v2] + dist2[n];
		}

		int result2 = INF;
		dist1 = dijkstra(v2);
		dist2 = dijkstra(v1);
		if(dist1[1] != INF && dist1[v1] != INF && dist2[n] != INF) {
			result2 = dist1[1] + dist1[v1] + dist2[n];
		}

		// result2 += dijkstra(1, v2);
		// result2 += dijkstra(v2, v1);
		// result2 += dijkstra(v1, n);

		int min = Math.min(result1, result2);
		if(min >= INF)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	public static int[] dijkstra(int x){
		Queue<Node> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		pq.add(new Node(x, 0));
		dist[x] = 0;

		while(!pq.isEmpty()){
			Node node = pq.poll();

			if(visit[node.to])
				continue;
			visit[node.to] = true;

			for(Node n : list[node.to]){
				if(dist[n.to] > dist[node.to] + n.value){
					dist[n.to] = dist[node.to] + n.value;
					pq.add(new Node(n.to, dist[n.to]));
				}
			}
		}
		return dist;
	}
}
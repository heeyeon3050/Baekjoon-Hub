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
	static final int INF = 10000000;
	static int n, m, x;

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
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		List<Node>[] list1 = new ArrayList[n+1];
		List<Node>[] list2 = new ArrayList[n+1]; //반대 버전
		for(int i=0; i<=n; i++){
			list1[i] = new ArrayList<>();
			list2[i] = new ArrayList<>();
		}

		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			list1[from].add(new Node(to, value));
			list2[to].add(new Node(from, value));
		}

		int[] dist1 = dijkstra(list1);
		int[] dist2 = dijkstra(list2);

		int max = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++){
			max = Math.max(max, dist1[i]+dist2[i]);
		}

		System.out.println(max);
	}

	public static int[] dijkstra(List<Node>[] list){
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
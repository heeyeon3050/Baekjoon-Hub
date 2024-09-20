import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static class Node implements Comparable<Node>{
		int from, to, value;

		public Node(int from, int to, int value){
			this.from = from;
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
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parent = new int[n+1];
		for(int i=1; i<=n; i++){
			parent[i] = i;
		}

		Queue<Node> pq = new PriorityQueue<>();
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			pq.add(new Node(a, b, c));
		}

		int size = pq.size();
		int answer = 0;
		for(int i=0; i<size; i++){
			Node node = pq.poll();

			if(find(node.from) != find(node.to)){
				answer += node.value;
				union(node.from, node.to);
			}
		}
		System.out.println(answer);
	}

	public static int find(int x){
		if(parent[x] != x)
			parent[x] = find(parent[x]);
		return parent[x];
	}

	public static void union(int x, int y){
		int rootX = find(x);
		int rootY = find(y);

		if(rootX < rootY){
			parent[rootY] = rootX;
		} else{
			parent[rootX] = rootY;
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static int[] parent;

	static class Edge{
		int from, to, cost;

		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		ArrayList<Edge> edges = new ArrayList<>();
		int answer = 0;

		for(int i=0; i<E; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.add(new Edge(a, b, c));
		}

		Collections.sort(edges, ((o1, o2) -> Integer.compare(o1.cost, o2.cost)));

		make();

		for(int i=0; i<E; i++){
			Edge edge = edges.get(i);
			if(union(edge.from, edge.to)){
				answer += edge.cost;
			}
		}

		System.out.println(answer);
	}

	private static void make(){
		parent = new int[V+1];
		for(int i=1; i<=V; i++){
			parent[i] = i;
		}
	}

	private static int find(int v){
		if(parent[v] == v)
			return v;
		return parent[v] = find(parent[v]);
	}

	private static boolean union(int a, int b){
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot){
			return false;
		}
		parent[bRoot] = aRoot;
		return true;
	}
}

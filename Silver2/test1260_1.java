package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test1260_1 {
	static int N, M, V;
	static int arr[][];
	static boolean visit[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		dfs(V);
		sb.append("\n");
		visit = new boolean[N+1];
		bfs(V);
		System.out.println(sb);
	}
	
	public static void dfs(int start) {
		sb.append(start + " ");
		visit[start] = true;
		for(int i=1; i<=N; i++) {
			if(arr[start][i]==1 && !visit[i]) {
				visit[i] = true;
				dfs(i);
			}
		}
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			start = queue.poll();
			sb.append(start + " ");
			
			for(int i=1; i<=N; i++) {
				if(arr[start][i]==1 && !visit[i]) {
					visit[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}

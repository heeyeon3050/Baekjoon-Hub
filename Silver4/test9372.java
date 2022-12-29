package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test9372 {
	static int arr[][];
	static boolean[] visit;
	static int N, M, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N+1][N+1];
			visit = new boolean[N+1];
			result = 0;
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
				arr[b][a] = 1;
			}
			bfs();
			sb.append(result-1 + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visit[1] = true;
		while(!queue.isEmpty()) {
			result++;
			int value = queue.poll();
			for(int i=1; i<=N; i++) {
				if(arr[value][i] != 0 && !visit[i]) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}
	}
}

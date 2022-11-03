package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test2606 {
	static int node[][]; //각 정점간 탐색 경로 저장
	static boolean visit[]; // 방문여부
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		node = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a][b] = 1;
			node[b][a] = 1;
		}
		bfs(1);
		//dfs(1);
		//System.out.println(cnt);
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visit[start] = true;
		queue.offer(start);
		int cnt = 0; //감염된 컴퓨터 수
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			for(int i=1; i<node.length; i++) {
				if(node[x][i]==1 && visit[i]!=true) {
					queue.offer(i);
					visit[i] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int start) {
		visit[start] = true;
		
		for(int i=1; i<node.length; i++) {
			if(node[start][i]==1 && visit[i]!=true) {
				cnt++;
				dfs(i);
			}
		}
	}
}

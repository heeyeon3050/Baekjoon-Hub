package Silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test10971 {
	static int N;
	static int cost[][];
	static boolean visit[];
	static int min = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<=N;i++) {
			visit[i]=true;
			dfs(i,i,0,0);
			visit[i]=false;
		}
		System.out.println(min);
	}
	
	public static void dfs(int start, int now, int sum, int cnt) {
		if(cnt == N-1) {
			if(cost[now][start]!=0) {
				sum+=cost[now][start];
				min = Math.min(min, sum);
			}
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visit[i] && cost[now][i]!=0) {
				visit[i] = true;
				dfs(start, i, sum + cost[now][i], cnt+1);
				visit[i] = false;
			}
		}
	}
}

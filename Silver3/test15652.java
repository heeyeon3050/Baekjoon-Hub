package Silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test15652 {
	static int N, M;
	static int num[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[M];
		dfs(1, 0);
		
		System.out.println(sb);
	}
	
	public static void dfs(int x, int cnt) {
		if(cnt == M) {
			for(int n : num) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}
		
		//중복 방문 고려할 필요 x
		for(int i=x; i<=N; i++) {
			num[cnt] = i;
			dfs(i, cnt+1);
		}
	}
}

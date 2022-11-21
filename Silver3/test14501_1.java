package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//브루트포스-재귀
public class test14501_1 {
	static int N;
	static int T[], P[];
	static int max = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		T = new int[N+1];
		P	= new int[N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(1, 0);
		System.out.println(max);
	}
	
	public static void dfs(int start, int sum) {
		if(start > N) {
			max = Math.max(max, sum);
			return;
		}
		
		if(start+T[start] <= N+1)
			dfs(start+T[start], sum+P[start]);
		else
			dfs(start+T[start], sum);
		
		dfs(start+1, sum);
	}
}

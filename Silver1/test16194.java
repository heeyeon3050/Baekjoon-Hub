package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;import java.util.Arrays;
import java.util.StringTokenizer;

public class test16194 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		int cost[] = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			dp[i] = cost[i];
		}
		
		dp[0] = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j]+cost[j]);
			}
		}
		
		System.out.println(dp[N]);
	}
}

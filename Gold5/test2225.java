package Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2225 {
	public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st = new StringTokenizer(br.readLine());
		  int N = Integer.parseInt(st.nextToken());
		  int K = Integer.parseInt(st.nextToken());
		  long dp[][] = new long[K+1][N+1];
		  int mod = 1000000000;
		
		  for(int i=1; i<=K; i++) 
			  dp[i][0] = 1;
		  
		  for(int i=1; i<=N; i++)
			  dp[1][i] = 1;
		  
		  for(int i=2; i<=K; i++) 
			  for(int j=1; j<=N; j++)
				  dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % mod;
		  
		  System.out.println(dp[K][N]);
	}
}

package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test10844 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long dp[][] = new long[N+1][10];
		int mod = 1000000000;
		long sum = 0;
		
		for(int i=1; i<10; i++)
			dp[1][i] = 1;
		
		for(int i=2; i<=N; i++) {
			dp[i][0] = dp[i-1][1];
			dp[i][9] = dp[i-1][8] % mod;
			
			for(int j=1; j<=8; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
			}
		}
		
		for(int i=0; i<=9; i++) {
			sum += dp[N][i];
			sum %= mod;
		}
		
		System.out.println(sum);
	}
}

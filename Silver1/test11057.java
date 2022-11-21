package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test11057 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long dp[][] = new long[N+1][10];
		
		for(int i=0; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		long answer[] = new long[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=9; j++) {
				for(int k=j; k<=9; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= 10007;
				}
				answer[i] += dp[i][j];
			}
        }
		
		System.out.println(answer[N] % 10007);
	} 
}
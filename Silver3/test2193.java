package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2193 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[N+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			//dp[i-1]은 뒤에 0이 올 수 있는 개수
			//dp[i-2]는 뒤에 1이 올 수 있는 개수
		}
		
		System.out.println(dp[N]);
	}
}

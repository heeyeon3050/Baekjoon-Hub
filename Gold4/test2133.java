package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2133 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		dp[2] = 3;
		
		for(int i=4; i<=N; i+=2) {
			dp[i] = dp[i-1] * i;
		}
		
		System.out.println(dp[N]);
	}
}

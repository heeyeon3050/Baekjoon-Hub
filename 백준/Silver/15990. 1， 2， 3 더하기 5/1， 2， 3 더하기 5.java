import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int MOD = 1000000009;

		int t = Integer.parseInt(br.readLine());
		int[][] dp = new int[100001][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for(int i=4; i<=100000; i++){
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
		}

		for(int tc=0; tc<t; tc++){
			int n = Integer.parseInt(br.readLine());
			int result1 = (dp[n][1] + dp[n][2]) % MOD;
			int result2 = (result1 + dp[n][3]) % MOD;
			sb.append(result2).append("\n");
		}

		System.out.println(sb);
	}
}
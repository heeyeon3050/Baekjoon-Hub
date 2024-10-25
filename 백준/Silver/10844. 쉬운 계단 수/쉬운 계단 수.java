import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int MOD = 1000000000;

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][10];
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;

		for(int i=2; i<=n; i++){
			for(int j=1; j<9; j++){
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
			}
			dp[i][0] = dp[i-1][1];
			dp[i][9] = dp[i-1][8];
		}

		int sum = 0;
		for(int i=0; i<=9; i++){
			sum = (sum + dp[n][i]) % MOD;
		}

		System.out.println(sum);
	}
}
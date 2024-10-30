import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int MOD = 10007;

		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n+1][10];
		for(int i=0; i<=9; i++){
			dp[1][i] = 1;
		}

		for(int i=1; i<=n; i++){
			for(int j=0; j<=9; j++){
				for(int k=0; k<=j; k++){
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= MOD;
				}
			}
		}

		int sum = 0;
		for(int i=0; i<=9; i++){
			sum += dp[n][i];
			sum %= MOD;
		}

		System.out.println(sum);
	}
}
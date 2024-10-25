import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++){
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n+1];
			dp[0] = 1;
			dp[1] = 1;
			if(n >= 2)
				dp[2] = 2;

			for(int i=3; i<=n; i++){
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}

			sb.append(dp[n]).append("\n");
		}

		System.out.println(sb);
	}
}
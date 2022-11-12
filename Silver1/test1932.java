package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1932 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n+1][n+1];
		int dp[][] = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				if(j==1)
					dp[i][j] = dp[i-1][1] + arr[i][j];
				else if(j==i)
					dp[i][j] = dp[i-1][j-1] + arr[i][j];
				else
					dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
			}
		}
		
		int max = -1;
		for(int i=1; i<=n; i++) {
			max = Math.max(max, dp[n][i]);
		}
	
		System.out.println(max);
	}
}
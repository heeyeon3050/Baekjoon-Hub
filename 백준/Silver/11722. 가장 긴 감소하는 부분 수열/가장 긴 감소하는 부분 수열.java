import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MIN_VALUE;
		int[] dp = new int[n+1];
		Arrays.fill(dp, 1);
		for(int i=1; i<=n; i++){
			for(int j=1; j<i; j++){
				if(arr[i] < arr[j]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			min = Math.max(min, dp[i]);
		}

		System.out.println(min);
	}
}
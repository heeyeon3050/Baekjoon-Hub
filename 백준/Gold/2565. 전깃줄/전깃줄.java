import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n];
		int[][] wire = new int[n][2];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(wire, (o1, o2) -> Integer.compare(o1[0], o2[0]));

		for(int i=0; i<n; i++){
			dp[i] = 1; // 최소 개수인 1로 초기화

			//LIS
			for(int j=0; j<i; j++){
				if(wire[i][1] > wire[j][1])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}

		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			max = Math.max(max, dp[i]);
		}

		System.out.println(n - max);
	}
}
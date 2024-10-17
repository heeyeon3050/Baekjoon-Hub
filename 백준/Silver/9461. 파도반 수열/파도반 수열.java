import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] dp = new long[101]; // N이 최대 100까지므로 101로 선언
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;

		// 6부터 100까지의 파도반 수열을 미리 계산
		for (int i = 6; i <= 100; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}

		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");  // 미리 계산한 값을 바로 출력
		}

		System.out.println(sb);
	}
}
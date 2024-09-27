import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] t = new int[n+1];
		int[] p = new int[n+1];
		int[] dp = new int[n+2];

		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<=n; i++){
			dp[i+1] = Math.max(dp[i+1], dp[i]); //일을 안한 경우
			if(i+t[i] <= n + 1) //일을 한 경우
				dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]);
		}

		System.out.println(dp[n+1]);
	}
}
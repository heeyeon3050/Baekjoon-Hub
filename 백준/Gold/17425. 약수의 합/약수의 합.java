import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int MAX = 1_000_001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] sum = getDivisorSum();

		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++){
			int n = Integer.parseInt(br.readLine());
			sb.append(sum[n]).append("\n");
		}
		System.out.println(sb);
	}

	public static long[] getDivisorSum(){
		long[] dp = new long[MAX];
		Arrays.fill(dp, 1);

		for(int i=2; i<MAX; i++){
			for(int j=1; i*j<MAX; j++){
				dp[i*j] += i; //i가 i*j의 약수
			}
		}

		long[] sum = new long[MAX];
		for(int i=1; i<MAX; i++){
			sum[i] = sum[i-1] + dp[i];
		}

		return sum;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n+1];
		dp = new int[k+1];
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = 1;
		System.out.println(bottomUp());
	}

	public static int bottomUp(){
		for(int i=0; i<n; i++){
			for(int j=arr[i]; j<=k; j++){
				dp[j] += dp[j-arr[i]]; //j원을 만드는데 가능한 경우의 수
			}
		}
		return dp[k];
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		int[] dp1 = new int[n+1];
		int[] dp2 = new int[n+1];
		for(int i=1; i<=n; i++){
			dp1[i] = Math.max(arr[i], dp1[i-1] + arr[i]);
			max = Math.max(max, dp1[i]); //수를 제거하지 않았을 경우의 최대값
		}

		dp2[n] = arr[n];
		for(int i=n-1; i>=1; i--){
			dp2[i] = Math.max(arr[i], dp2[i+1] + arr[i]);
		}


		//수를 제거했을 경우의 최대값
		for(int i=1; i<n; i++){
			int result = dp1[i-1] + dp2[i+1];
			max = Math.max(max, result);
		}

		System.out.println(max);
	}
}
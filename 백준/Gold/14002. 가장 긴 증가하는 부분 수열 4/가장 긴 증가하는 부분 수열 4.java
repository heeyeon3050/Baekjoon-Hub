import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n+1];
		Arrays.fill(dp, 1);
		for(int i=1; i<=n; i++){
			for(int j=1; j<i; j++){
				if(arr[i] > arr[j]){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int idx = -1;
		for(int i=1; i<=n; i++){
			if(max < dp[i]){
				max = dp[i];
				idx = i;
			}
		}

		Stack<Integer> stack = new Stack<>();
		int value = max;
		for(int i=idx; i>=1; i--){
			if(dp[i] == value){
				stack.push(arr[i]);
				value--;
			}
		}

		sb.append(max).append("\n");
		while(!stack.isEmpty()){
			sb.append(stack.pop()).append(" ");
		}

		System.out.println(sb);
	}
}
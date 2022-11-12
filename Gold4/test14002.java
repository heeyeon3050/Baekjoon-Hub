package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class test14002 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		int arr[] = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			dp[i]=1;
			for(int j=1; j<i; j++) {
				if(arr[i]>arr[j] && dp[i]<=dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		int max = -1;
		for(int i=1; i<=N; i++)
			max = Math.max(max, dp[i]);
		
		System.out.println(max);
		
		Stack<Integer> stack = new Stack<>();
		for(int i=N; i>=1; i--) {
			if(dp[i] == max) {
				stack.push(arr[i]);
				max--;
			}
		}
		
		while(!stack.empty())
			sb.append(stack.pop() + " ");
		
		System.out.println(sb);
	}
}
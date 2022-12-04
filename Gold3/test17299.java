package Gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class test17299 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int cnt[] = new int[1000001];
		int ans[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[arr[i]]++;
		}
		
		for(int i=0; i<N; i++) {
			while(!stack.isEmpty() && cnt[arr[stack.peek()]] < cnt[arr[i]]) {
				ans[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty())
			ans[stack.pop()] = -1;
		
		for(int i=0; i<N; i++) {
			sb.append(ans[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}
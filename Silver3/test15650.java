package Silver3;

import java.util.Scanner;

public class test15650 {
	static int N, M;
	static boolean[] isUsed;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		isUsed = new boolean[N];
		arr = new int[M];
		
		dfs(0, 0);
		
		System.out.println(sb);
	}
	
	private static void dfs(int idx, int start) {
		if(idx == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=start; i<N; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				arr[idx] = i+1;
				dfs(idx+1, i+1);
				isUsed[i] = false;
			}
		}
	}
}

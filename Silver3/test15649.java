package Silver3;

import java.util.Scanner;

public class test15649 {
	static int N, M;
	static int[] arr;
	static boolean[] isUsed;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		isUsed = new boolean[N];
		arr = new int[M];
		
		recursion(0);
		
		System.out.println(sb);
	}
	
	private static void recursion(int idx) {
		if(idx == M) {
			for(int val : arr) {
				sb.append(val).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!isUsed[i]) {
				isUsed[i] = true;
				arr[idx] = i+1;
				recursion(idx+1);
				isUsed[i] = false;
			}
		}
	}
}

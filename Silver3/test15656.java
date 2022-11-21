package Silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test15656 {
	static int N, M;
	static int arr[];
	static int num[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		num = new int[M];
		visit = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		dfs(0, 0);
		
		System.out.println(sb);
	}
	
	public static void dfs(int x, int cnt) {
		if(cnt == M) {
			for(int n : num) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=x; i<N; i++) {
			num[cnt] = arr[i];
			dfs(i, cnt+1);
		}
	}
}

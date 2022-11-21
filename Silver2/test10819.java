package Silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test10819 {
	static boolean visit[];
	static int num[];
	static int arr[];
	static int N;
	static int max = Integer.MIN_VALUE;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visit = new boolean[N];
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		System.out.println(max);
	}
	
	public static void dfs(int x, int cnt) {
		if(cnt == N) {
			int sum = 0;
			for(int i=0; i<N-1; i++) {
				sum += Math.abs(num[i]-num[i+1]);
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				num[x] = arr[i];
				dfs(x+1, cnt+1);
				visit[i] = false;
			}
		}
	}
}

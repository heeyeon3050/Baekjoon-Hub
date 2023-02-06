package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test15664 {
	static int N, M;
	static int arr[];
	static int answer[];
	static boolean visit[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visit = new boolean[N];
		answer = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		dfs(0, 0);
		
	}
	
	public static void dfs(int start, int cnt) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		}
		
		else {
			int before = 0;
			for(int i=start; i<N; i++) {
				if(arr[i] == before || visit[i])
					continue;
				else {
					before = arr[i];
					visit[i] = true;
					answer[cnt] = arr[i];
					dfs(i+1, cnt+1);
					visit[i] = false;
				}
			}
		}
	}
}

package Silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test18290 {
	static int N, M, K;
	static int arr[][];
	static boolean visit[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int sum = 0;
	static boolean flag = true;
	static int max = Integer.MIN_VALUE;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0, 0);
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int cnt, int sum) {
		if(cnt == K) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=x; i<N; i++) {
			for(int j=y; j<M; j++) {
				if(!visit[i][j]) {
					flag = true;
					for(int k=0; k<4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx>=0 && ny>=0 && nx<N && ny<M) {
							if(visit[nx][ny]) {
								flag = false;
								break;
							}
						}
					}
					if(flag) {
						visit[i][j] = true;
						dfs(x, y, cnt+1, sum + arr[i][j]);
						visit[i][j] = false;
					}
				}
			}
		}
	}
}

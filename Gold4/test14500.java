package Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test14500 {
	static int N, M;
	static int map[][];
	static int max = -1;
	static boolean visit[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visit[i][j] = true;
				dfs(i, j, map[i][j], 1);
				visit[i][j] = false;
			}
		}
		
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, int sum, int cnt) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny]) {
				
				if(cnt == 2) {
					visit[nx][ny] = true;
					dfs(x, y, sum + map[nx][ny], cnt+1);
					visit[nx][ny] = false;
				}
				
				visit[nx][ny] = true;
				dfs(nx, ny, sum + map[nx][ny], cnt+1);
				visit[nx][ny] = false;
			}
		}
	}
}

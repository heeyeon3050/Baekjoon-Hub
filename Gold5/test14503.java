package Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test14503 {
	static int N, M, r, c, d;
	static int map[][];
	static int dx[] = {-1, 0, 1, 0}; //북동남서
	static int dy[] = {0, 1, 0, -1};
	static int cnt = 1;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(r, c, d);
		System.out.println(cnt);
	}
	
	public static void dfs(int x, int y, int d) {
		map[x][y] = -1;
		
		for(int i=0; i<4; i++) {
			d = (d+3) % 4; //왼쪽 방향으로 변환
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny] == 0) {
				cnt++;
				dfs(nx, ny, d);
				return;
			}
		}
		
		int back = (d+2)%4; //후진
		int nx = x + dx[back];
		int ny = y + dy[back];
		
		if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]!=1) {
			dfs(nx, ny, d);
		}
	}
}

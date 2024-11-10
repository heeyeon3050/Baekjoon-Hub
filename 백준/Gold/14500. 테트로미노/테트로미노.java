import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int n, m;
	static int[][] arr;
	static boolean[][] visit;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				visit[i][j] = true;
				dfs(1, i, j, arr[i][j]);
				visit[i][j] = false;
			}
		}

		System.out.println(max);
	}

	public static void dfs(int depth, int x, int y, int num){
		if(depth == 4){
			max = Math.max(max, num);
			return;
		}

		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if(visit[nx][ny])
				continue;

			visit[nx][ny] = true;
			dfs(depth+1, nx, ny, num+arr[nx][ny]);
			visit[nx][ny] = false;

			if(depth == 2){
				visit[nx][ny] = true;
				dfs(depth+1, x, y, num+arr[nx][ny]); //이동한 값은 받으면서 그자리에서 한 번 더 호출
				visit[nx][ny] = false;
			}
		}
	}
}
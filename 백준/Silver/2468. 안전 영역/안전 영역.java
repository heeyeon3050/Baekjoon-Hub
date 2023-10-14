import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int[][] arr;
	static boolean[][] visit;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visit = new boolean[N][N];

		int maxHeight = 0;
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, arr[i][j]);
			}
		}


		int max = Integer.MIN_VALUE;
		for(int i=0; i<=maxHeight; i++) {
			visit = new boolean[N][N];
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(!visit[j][k] && arr[j][k] > i){
						visit[j][k]	= true;
						dfs(j, k, i);
						cnt++;
					}
				}
			}
			max = Math.max(max, cnt);
		}

		System.out.println(max);
	}

	private static void dfs(int x, int y, int height){
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) continue;

			if(arr[nx][ny] > height){
				visit[nx][ny] = true;
				dfs(nx, ny, height);
			}
		}
	}
}

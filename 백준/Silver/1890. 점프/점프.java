import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] arr;
	static long[][] cnt;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		cnt = new long[N][N];

		for (long[] col : cnt)
			Arrays.fill(col, -1);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		solve(0, 0);

		System.out.println(cnt[0][0]);
	}

	public static long solve(int x, int y){
		if(x == N-1 && y == N-1)
			return 1;

		if(cnt[x][y] == -1){
			cnt[x][y] = 0;
			for(int i=0; i<2; i++){
				int nx = x + dx[i] * arr[x][y];
				int ny = y + dy[i] * arr[x][y];

				if(nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				cnt[x][y] += solve(nx, ny);
			}
		}

		return cnt[x][y];
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 1, -1, 0};
	static int[] dy = {1, 0, 0, -1};
	static int n;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][n];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				max = Math.max(max, dfs(i, j));
			}
		}

		System.out.println(max);
	}

	public static int dfs(int x, int y){
		if(dp[x][y] != 0)
			return dp[x][y];

		dp[x][y] = 1;

		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			if(arr[x][y] < arr[nx][ny]) {
				dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+1);
				dfs(nx, ny);
			}
		}
		return dp[x][y];
	}
}
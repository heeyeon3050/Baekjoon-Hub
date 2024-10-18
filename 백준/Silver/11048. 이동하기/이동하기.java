import java.io.*;
import java.util.*;


public class Main {
	static int[] dx = {1, 0 , 1};
	static int[] dy = {0, 1, 1};
	static int n, m;
	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n+1][m+1];
		dp = new int[n+1][m+1];
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		//bottom-up
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				dp[i][j] = Math.max(arr[i][j]+dp[i-1][j], arr[i][j]+dp[i][j-1]); //대각선은 [왼쪽 아래] [오른쪽 아래] 보다 작으므로 생략
			}
		}

		//dfs(0, 0);

		System.out.println(dp[n][m]);
	}

	//top-down 0-based
	public static int dfs(int x, int y){
		if (dp[x][y] != -1) {
			return dp[x][y];
		}

		if (x == n-1 && y == m-1) {
			return arr[x][y];
		}

		// (x, y)의 사탕 개수를 모르고 있는 경우
		dp[x][y] = arr[x][y];

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= n || ny >= m) {
				continue;
			}

			dp[x][y] = Math.max(dp[x][y], arr[x][y] + dfs(nx, ny));
		}

		return dp[x][y];
	}

	//dp 추가안한 버전
	// public static void dfs(int x, int y, int candy){
	// 	if(x == n-1 && y == m-1){
	// 		max = Math.max(max, candy + arr[x][y]);
	// 		return;
	// 	}
	//
	// 	if(x+1 < n)
	// 		dfs(x+1, y, candy + arr[x][y]);
	//
	// 	if(y+1 < m)
	// 		dfs(x, y+1, candy + arr[x][y]);
	//
	// 	if(x+1 < n && y+1 < m)
	// 		dfs(x+1, y+1, candy+arr[x][y]);
	//
	// }
}
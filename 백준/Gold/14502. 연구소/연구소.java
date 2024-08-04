import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Point{
		int x, y;

		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int n, m;
	static int[][] arr;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(max);
	}

	public static void dfs(int cnt){
		if(cnt == 3){
			bfs();
			return;
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(arr[i][j] == 0){
					arr[i][j] = 1;
					dfs(cnt+1);
					arr[i][j] = 0;
				}
			}
		}
	}

	public static void bfs(){
		Queue<Point> queue = new ArrayDeque<>();

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(arr[i][j] == 2)
					queue.add(new Point(i, j));
			}
		}

		int temp[][] = new int[n][m];
		for(int i=0; i<n; i++){
			temp[i] = arr[i].clone();
		}

		while(!queue.isEmpty()){
			Point now = queue.poll();

			for(int i=0; i<4; i++){
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if(temp[nx][ny] == 0){
					queue.add(new Point(nx, ny));
					temp[nx][ny] = 2;
				}
			}
		}

		check(temp);
	}

	public static void check(int[][] temp){
		int safe = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(temp[i][j] == 0)
					safe++;
			}
		}

		max = Math.max(max, safe);
	}
}

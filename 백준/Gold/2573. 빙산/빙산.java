import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int n, m;
	static int[][] arr;
	static Queue<Point> queue;

	public static class Point{
		int x, y;

		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		queue = new ArrayDeque<>();

		arr = new int[n][m];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > 0)
					queue.add(new Point(i, j));
			}
		}

		System.out.println(fuze());
	}

	public static int fuze(){
		int year = 1;
		int[][] temp = new int[n][m];
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<n; i++)
				temp[i] = arr[i].clone();

			for(int i=0; i<size; i++){
				Point point = queue.poll();

				int seaNum = 0;
				for(int j=0; j<4; j++){
					int nx = point.x + dx[j];
					int ny = point.y + dy[j];

					if(nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;

					if(arr[nx][ny] == 0){
						seaNum++;
					}
				}
				if(arr[point.x][point.y] - seaNum < 0)
					temp[point.x][point.y] = 0;
				else
					temp[point.x][point.y] -= seaNum;
			}

			for(int i=0; i<n; i++)
				arr[i] = temp[i].clone();
			int cnt = count(arr);
			if(cnt >= 2){
				return year;
			}
			year++;

			for(int i=0; i<n; i++){
				for(int j=0; j<m; j++){
					if(arr[i][j] > 0){
						queue.add(new Point(i, j));
					}
				}
			}
		}
		return 0;
	}

	public static int count(int[][] arr){
		boolean[][] visit = new boolean[n][m];

		int cnt = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(arr[i][j] > 0 && !visit[i][j]){
					visit[i][j] = true;
					dfs(i, j, visit);
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void dfs(int x, int y, boolean[][] visit){
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >=n || ny < 0 || ny >=m)
				continue;

			if(arr[nx][ny] > 0 && !visit[nx][ny]){
				visit[nx][ny] = true;
				dfs(nx, ny, visit);
			}
		}
	}
}
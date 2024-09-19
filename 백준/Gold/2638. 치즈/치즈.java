import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int n, m;
	static int[][] arr;
	static Queue<Point> queue;
	static boolean[][] visit;
	static int time = 0;
	static int cheeseCnt = 0;

	public static class Point{
		int x, y;

		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		queue = new ArrayDeque<>();

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1){
					queue.add(new Point(i, j));
				}
			}
		}

		melt();

		System.out.println(time);
	}

	public static void melt(){
		while(!queue.isEmpty()) { // 매번 새로운 외부 공기를 찾아야 함
			visit = new boolean[n][m];
			dfs(0, 0); // 외부 공기 찾기

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Point point = queue.poll(); //치즈가 안녹을 수 있기 때문에 잠깐 peek

				int cnt = 0;
				for (int j = 0; j < 4; j++) {
					int nx = point.x + dx[j];
					int ny = point.y + dy[j];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;

					if (arr[nx][ny] == 2) { //외부 공기이면
						cnt++;
					}
				}

				if (cnt >= 2) {
					arr[point.x][point.y] = 0;
				} else {
					queue.add(new Point(point.x, point.y));
				}
			}
			time++;
		}
	}

	public static void dfs(int x, int y){
		visit[x][y] = true;
		arr[x][y] = 2; //외부 공기라는 의미로 2표시

		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if(visit[nx][ny] || arr[nx][ny] == 1)
				continue;

			dfs(nx, ny);
		}
	}
}
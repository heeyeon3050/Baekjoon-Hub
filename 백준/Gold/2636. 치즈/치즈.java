import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int n, m;
	static int[][] arr;
	static boolean[][] visit;
	static int cheese;

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

		arr = new int[n][m];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) cheese++;
			}
		}

		int prev = 0;
		int time = 0;
		while(cheese > 0){
			prev = cheese; // 현재 치즈 개수 저장
			time++;
			visit = new boolean[n][m];
			bfs(0, 0); // 외부 공기 기준으로 치즈 녹이기
		}

		System.out.println(time);
		System.out.println(prev);
	}

	public static void bfs(int x, int y){
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visit[x][y] = true;

		while(!queue.isEmpty()){
			Point now = queue.poll();

			for(int i=0; i<4; i++){
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if(visit[nx][ny])
					continue;

				if(arr[nx][ny] == 0){
					queue.add(new Point(nx, ny));
				} else if(arr[nx][ny] == 1){
					arr[nx][ny] = 0;
					cheese--;
				}
				visit[nx][ny] = true;
			}
		}
	}
}
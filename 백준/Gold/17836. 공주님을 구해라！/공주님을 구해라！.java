import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int x, y, gum;

		public Point(int x, int y, int gum){
			this.x = x;
			this.y = y;
			this.gum = gum;
		}
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	static boolean visit[][][];
	static int[][] arr;
	static int n, m, t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		arr = new int[n+1][m+1];
		visit = new boolean[n+1][m+1][2];

		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = bfs();
		if(time <= t)
			System.out.println(time);
		else
			System.out.println("Fail");
	}

	public static int bfs(){
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(1, 1, 0));
		visit[1][1][0] = true;

		int time = 0;
		while(!queue.isEmpty()){
			int size = queue.size();

			for(int i=0; i<size; i++){
				Point now = queue.poll();

				if(now.x == n && now.y == m){
					return time;
				}

				for(int j=0; j<4; j++){
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];

					if(nx <= 0 || nx > n || ny <= 0 || ny > m)
						continue;

					if(arr[nx][ny] == 0 && !visit[nx][ny][now.gum]){
						visit[nx][ny][now.gum] = true;
						queue.add(new Point(nx, ny, now.gum));
					} else if(arr[nx][ny] == 1 && !visit[nx][ny][now.gum]){
						if(now.gum == 1){
							visit[nx][ny][now.gum] = true;
							queue.add(new Point(nx, ny, now.gum));
						}
					} else if(arr[nx][ny] == 2 && !visit[nx][ny][now.gum]){
						visit[nx][ny][1] = true;
						queue.add(new Point(nx, ny, 1));
					}
				}
			}
			time++;
		}

		return Integer.MAX_VALUE;
	}
}
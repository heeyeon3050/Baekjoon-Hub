import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};

	static int[][] arr;
	static boolean[][] visit;
	static int n, l, r;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visit = new boolean[n][n];
			boolean moved = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j]) {
						if (bfs(i, j)) {
							moved = true;
						}
					}
				}
			}

			if (!moved) break;
			answer++;
		}

		System.out.println(answer);
	}

	static public boolean bfs(int x, int y) {
		Queue<Point> queue = new ArrayDeque<>();
		List<Point> list = new ArrayList<>();
		queue.add(new Point(x, y));
		visit[x][y] = true;
		list.add(new Point(x, y));

		int total = arr[x][y];
		int count = 1;

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

				if (!visit[nx][ny] && Math.abs(arr[now.x][now.y] - arr[nx][ny]) >= l && Math.abs(arr[now.x][now.y] - arr[nx][ny]) <= r) {
					queue.add(new Point(nx, ny));
					visit[nx][ny] = true;
					list.add(new Point(nx, ny));
					total += arr[nx][ny];
					count++;
				}
			}
		}

		if (count > 1) {
			int avg = total / count;
			for (Point p : list) {
				arr[p.x][p.y] = avg;
			}
			return true;
		}
		return false;
	}
}
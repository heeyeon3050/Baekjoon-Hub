import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int n;
	static int[][] arr;
	static int x, y;
	static int size = 2;
	static int time = 0;
	static int eatCount = 0;

	public static class Point {
		int x, y, dist;

		public Point(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					x = i;
					y = j;
					arr[i][j] = 0; // 아기 상어가 있던 자리는 빈칸으로 변경
				}
			}
		}

		while (true) {
			Point fish = bfs();
			if (fish == null) break; // 더 이상 먹을 물고기가 없으면 종료
			x = fish.x;
			y = fish.y;
			time += fish.dist; // 걸린 시간을 더해줌
			arr[x][y] = 0; // 물고기를 먹은 자리는 빈칸으로 만듦
			eatCount++;

			if (eatCount == size) {
				size++; // 먹은 물고기 수가 상어 크기만큼 되면 크기 증가
				eatCount = 0;
			}
		}

		System.out.println(time);
	}

	// BFS로 가장 가까운 물고기 찾기
	public static Point bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visit = new boolean[n][n];
		queue.add(new Point(x, y, 0));
		visit[x][y] = true;

		List<Point> fishList = new ArrayList<>();

		while (!queue.isEmpty()) {
			Point now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (visit[nx][ny] || arr[nx][ny] > size) continue;

				visit[nx][ny] = true;
				queue.add(new Point(nx, ny, now.dist + 1));

				if (arr[nx][ny] > 0 && arr[nx][ny] < size) {
					fishList.add(new Point(nx, ny, now.dist + 1));
				}
			}
		}

		if (fishList.isEmpty()) return null;

		// 가장 위쪽, 왼쪽에 있는 물고기를 찾기 위해 정렬
		fishList.sort((a, b) -> {
			if (a.dist == b.dist) {
				if (a.x == b.x) return a.y - b.y;
				return a.x - b.x;
			}
			return a.dist - b.dist;
		});

		return fishList.get(0); // 가장 가까운 물고기 리턴
	}
}
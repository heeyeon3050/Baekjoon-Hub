import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int r, c, cost;

		public Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };
	static int N;
	static int[][] arr, dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}

			arr = new int[N][N];
			dist = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			dijkstra();

			sb.append("Problem " + (T++) + ": " + dist[N-1][N-1] + "\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, arr[0][0]));
		dist[0][0] = arr[0][0];

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int cr = cur.r;
			int cc = cur.c;

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;

				if (dist[nr][nc] > dist[cr][cc] + arr[nr][nc]) {
					dist[nr][nc] = dist[cr][cc] + arr[nr][nc];
					pq.offer(new Node(nr, nc, dist[nr][nc]));
				}
			}
		}
	}
}
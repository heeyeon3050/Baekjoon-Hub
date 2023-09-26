import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  열쇠를 획득했을 경우에 대한 방문 기록을 가져야 함. -> 3차원 배열
 */

class Node {
	int row;
	int col;
	int cnt; //이동 횟수
	int key; //가지고 있는 열쇠 정보

	public Node(int row, int col, int cnt, int key) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.key = key;
	}
}

public class Main {
	public static int[] dx = new int[] { 0, 0, -1, 1 };
	public static int[] dy = new int[] { 1, -1, 0, 0 };
	public static char[][] map;
	public static boolean[][][] visited;
	public static Node start;
	public static int N, M, ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[64][N][M]; //열쇠는 최대 6개 이므로 2^6=64

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') //시작 위치 설정
					start = new Node(i, j, 0, 0);
			}
		}
		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(start.row, start.col, 0, 0));
		visited[0][start.row][start.col] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();
			int row = node.row;
			int col = node.col;
			int cnt = node.cnt;
			int key = node.key;

			if (map[row][col] == '1') { //만약 해당 위치가 출구라면 이동 횟수 반환
				return cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nr = row + dx[i];
				int nc = col + dy[i];

				//경계 체크, 방문 체크, 벽이 아닌 경우
				if (isBoundary(nr, nc) && map[nr][nc] != '#' && !visited[key][nr][nc]) {
					if (map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1') {
						visited[key][nr][nc] = true;
						q.offer(new Node(nr, nc, cnt + 1, key));

					} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
						int newKey = 1 << (map[nr][nc] - 'a'); //열쇠일 경우 2의 제곱
						newKey = newKey | key;
						if (!visited[newKey][nr][nc]) {
							visited[key][nr][nc] = true;
							visited[newKey][nr][nc] = true;
							q.offer(new Node(nr, nc, cnt + 1, newKey));
						}

					} else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {

						int door = 1 << (map[nr][nc] - 'A');
						if ((key & door) > 0) { // 값이 같다면. 해당 문을 열 수 있는 열쇠가 있다면.
							visited[key][nr][nc] = true;
							q.offer(new Node(nr, nc, cnt + 1, key));
						}
					}
				}
			}
		}
		return -1;
	}

	public static boolean isBoundary(int row, int col) {
		return (row >= 0 && row < N) && (col >= 0 && col < M);
	}

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;
		int y;
		int cnt; //이동 횟수
		int key; //가지고 있는 열쇠 정보

		public Node(int x, int y, int cnt, int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}

	public static int[] dx = new int[] { 0, 0, -1, 1 };
	public static int[] dy = new int[] { 1, -1, 0, 0 };
	public static char[][] arr;
	public static boolean[][][] visit;
	static int n, m;
	public static Node start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new char[n][m];
		visit = new boolean[64][n][m]; //열쇠가 6개이므로 2^6 = 64

		for(int i=0; i<n; i++){
			String str = br.readLine();
			for(int j=0; j<m; j++){
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == '0')
					start = new Node(i, j, 0, 0);
			}
		}

		System.out.println(bfs());
	}

	public static int bfs(){
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(start);
		visit[0][start.x][start.y] = true;

		while(!queue.isEmpty()){
				Node now = queue.poll();
			for(int j=0; j<4; j++){
				int nx = now.x + dx[j];
				int ny = now.y + dy[j];

				if(nx < 0 || nx >= n || ny < 0 || ny >= m || visit[now.key][nx][ny])
					continue;

				if(arr[nx][ny] == '#')
					continue;

				if(arr[nx][ny] == '1')
					return now.cnt+1;

				if(arr[nx][ny] == '.' || arr[nx][ny] == '0'){
					visit[now.key][nx][ny] = true;
					queue.offer(new Node(nx, ny, now.cnt+1, now.key));
				} else if(arr[nx][ny] >= 'a' && arr[nx][ny] <= 'f'){
					int newKey = 1 << (arr[nx][ny] - 'a'); //2의 제곱승
					newKey = newKey | now.key;
					if(!visit[newKey][nx][ny]){
						visit[now.key][nx][ny] = true;
						visit[newKey][nx][ny] = true;
						queue.offer(new Node(nx, ny, now.cnt+1, newKey));
					}
				} else if(arr[nx][ny] >= 'A' && arr[nx][ny] <= 'F'){
					int door = 1 << (arr[nx][ny] - 'A');
					if((now.key & door) > 0){
						visit[now.key][nx][ny] = true;
						queue.offer(new Node(nx, ny, now.cnt+1, now.key));
					}
				}
			}
		}
		return -1;
	}
}
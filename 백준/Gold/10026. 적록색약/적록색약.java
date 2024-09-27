import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, 1, -1, 0};
	static int n;
	static char[][] arr, arr1;
	static boolean[][] visit;
	public static class Node{
		int x, y;

		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		arr1 = new char[n][n];
		visit = new boolean[n][n];

		for(int i=0; i<n; i++){
			String str = br.readLine();
			for(int j=0; j<n; j++){
				if(str.charAt(j) == 'G'){
					arr1[i][j] = 'R';
				} else{
					arr1[i][j] = str.charAt(j);
				}
				arr[i][j] = str.charAt(j);
			}
		}

		//적록색약이 아닌 경우
		int cnt = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(!visit[i][j]) {
					visit[i][j] = true;
					bfs(arr, i, j);
					cnt++;
				}
			}
		}

		//적록색약인 경우
		visit = new boolean[n][n];
		int cnt1 = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(!visit[i][j]) {
					visit[i][j] = true;
					bfs(arr1, i, j);
					cnt1++;
				}
			}
		}

		System.out.println(cnt + " " + cnt1);
	}

	public static void bfs(char[][] arr, int x, int y){
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(x, y));
		char color = arr[x][y];

		while(!queue.isEmpty()){
			Node now = queue.poll();

			for(int i=0; i<4; i++){
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if(nx < 0 || nx >= n || ny < 0 || ny >= n){
					continue;
				}

				if(visit[nx][ny])
					continue;

				if(color == arr[nx][ny]){
					queue.add(new Node(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
	}
}
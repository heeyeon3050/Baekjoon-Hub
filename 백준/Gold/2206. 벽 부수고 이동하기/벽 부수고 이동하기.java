import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static class Node{
		int x, y, cnt;
		boolean destroy;

		public Node(int x, int y, int cnt, boolean destroy){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.destroy = destroy;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++){
			String str = br.readLine();
			//System.out.println(str);
			for(int j=0; j<m; j++){
				//System.out.println(j);
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		boolean[][][] visit = new boolean[n][m][2];

		Queue<Node> queue = new ArrayDeque<>();
		queue.add(new Node(0, 0, 1, false));

		while(!queue.isEmpty()){
			int size = queue.size();

			for(int i=0; i<size; i++){
				Node now = queue.poll();

				if(now.x == n-1 && now.y == m-1){
					System.out.println(now.cnt);
					return;
				}

				for(int j=0; j<4; j++){
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];

					if(nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;

					if(arr[nx][ny] == 0){
						if(!now.destroy && !visit[nx][ny][0]){ //벽 부순 적 없는 경우
							queue.add(new Node(nx, ny, now.cnt+1, false));
							visit[nx][ny][0] = true;
						} else{
							if(now.destroy && !visit[nx][ny][1]){ //벽 부순 적 있는 경우
								queue.add(new Node(nx, ny, now.cnt+1, true));
								visit[nx][ny][1] = true;
							}
						}
					} else {
						if(!now.destroy && !visit[nx][ny][0]){ //벽 부순 적 없는 경우
							queue.add(new Node(nx, ny, now.cnt+1, true));
							visit[nx][ny][1] = true;
						}
					}
				}
			}
		}

		System.out.println(-1);
	}
}
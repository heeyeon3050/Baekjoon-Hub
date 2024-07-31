import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int z, x, y;

		public Point(int z, int x, int y){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int[] dx = {0, -1, 0, 1, 0, 0};
	static int[] dy = {1, 0, -1, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int[][][] arr = new int[h][n][m];
		Queue<Point> queue = new ArrayDeque<>();

		boolean flag = false;
		for(int i=0; i<h; i++){
			for(int j=0; j<n; j++){
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<m; k++){
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if(arr[i][j][k] == 1){
						queue.add(new Point(i, j, k));
					} else {
						flag = true;
					}
				}
			}
		}

		if(!flag){
			System.out.println(0);
			return;
		}

		int day = 0;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i=0; i<size; i++){
				Point now = queue.poll();

				for(int j=0; j<6; j++){
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];
					int nz = now.z + dz[j];

					if(nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h)
						continue;

					if(arr[nz][nx][ny] == 0) {
						arr[nz][nx][ny] = 1;
						queue.add(new Point(nz, nx, ny));
					}
				}
			}
			day++;
		}

		for(int i=0; i<h; i++){
			for(int j=0; j<n; j++){
				for(int k=0; k<m; k++){
					if(arr[i][j][k] == 0){
						System.out.println(-1);
						return;
					}
				}
			}
		}

		System.out.println(day-1);
	}
}
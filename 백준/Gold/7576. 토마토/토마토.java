import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int x, y;

		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		Queue<Point> queue = new ArrayDeque<>();
		boolean flag = false;
        
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1){
					queue.add(new Point(i, j));
				} else {
					flag = true;
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

				for(int j=0; j<4; j++){
					int nx = now.x + dx[j];
					int ny = now.y + dy[j];

					if(nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;

					if(arr[nx][ny] == 0) {
						arr[nx][ny] = 1;
						queue.add(new Point(nx, ny));
					}
				}
			}
			day++;
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(arr[i][j] == 0){
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(day-1);
	}
}
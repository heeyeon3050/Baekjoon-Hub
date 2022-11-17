package Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test7569 {
	static int M, N, H;
	static int map[][][];
	static int dx[] = {0, 0, 1, -1, 0, 0};
	static int dy[] = {1, -1, 0, 0, 0, 0};
	static int dz[] = {0, 0, 0, 0, 1, -1};
	static Queue<Point> queue = new LinkedList<>();
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0; k<M; k++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					
					if(map[i][j][k]==1)
						queue.offer(new Point(i, j, k));
					}
			}
		}
		bfs();
		
		int max = -1;
		for(int i=0; i<H; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(max, map[i][j][k]);
				}
			}
		}
		
		System.out.println(max-1);
	}
	
	public static void bfs() {
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			for(int i=0; i<6; i++) {
				int nz = now.z + dz[i];
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx>=0 && ny>=0 && nz>=0 && nx<N && ny<M && nz<H) {
					if(map[nz][nx][ny]==0) {
						map[nz][nx][ny] = map[now.z][now.x][now.y] + 1;
						queue.add(new Point(nz, nx, ny));
					}
				}
			}
		}
	}
}

class Point{
	int z;
	int x;
	int y;
	
	Point(int z, int x, int y){
		this.z = z;
		this.x = x;
		this.y = y;
	}
}
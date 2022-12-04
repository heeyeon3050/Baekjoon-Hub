package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x;
	int y;
	int cnt;
	
	Point(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	
	@Override
	public int compareTo(Point o) {
		return cnt - o.cnt;
	}
}

public class test1261 {
	static int N, M;
	static int map[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) -'0';
			}
		}
		
		bfs();
	}
	
	public static void bfs() {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.offer(new Point(0, 0, 0));
		
		boolean visit[][] = new boolean[N][M];
		visit[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.x==N-1 && p.y==M-1) {
				System.out.println(p.cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny]) {
					if(map[nx][ny]==0) {
						visit[nx][ny] = true;
						queue.offer(new Point(nx, ny, p.cnt));
					}
					
					else if(map[nx][ny]==1) {
						visit[nx][ny] = true;
						queue.offer(new Point(nx, ny, p.cnt+1));
					}
				}
			}
		}
	}
}

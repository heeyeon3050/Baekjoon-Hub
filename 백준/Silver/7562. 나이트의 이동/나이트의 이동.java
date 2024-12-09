import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int l;
	static int map[][];
	static int a2, b2;
	static int dx[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
	static boolean visit[][];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			l = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int b1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			a2 = Integer.parseInt(st.nextToken());
			b2 = Integer.parseInt(st.nextToken());
			
			visit = new boolean[l][l];
			map = new int[l][l];
			visit[a1][b1] = true;
            
			bfs(a1, b1);
		}
		
		System.out.println(sb);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			if(nowX == a2 && nowY == b2) {
				sb.append(map[a2][b2] + "\n");
				return;
			}
			
			for(int i=0; i<8; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX>=0 && nextY>=0 && nextX<l && nextY<l && !visit[nextX][nextY]) {
					queue.add(new int[] {nextX, nextY});
					visit[nextX][nextY] = true;
					map[nextX][nextY] = map[nowX][nowY] + 1;
				}
			}
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int arr[][];
	static boolean visit[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		visit[0][0] = true;
		bfs(0, 0);
		System.out.println(arr[N-1][M-1]);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0; i<4; i++) {
				int nextX= nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX>=0 && nextY>=0 && nextX<N && nextY<M) {
					if(arr[nextX][nextY]==1 && !visit[nextX][nextY]) {
						queue.add(new int[] {nextX, nextY});
						arr[nextX][nextY] = arr[nowX][nowY] + 1;
						visit[nextX][nextY] = true;
					}
				}
			}
		}
	}
}
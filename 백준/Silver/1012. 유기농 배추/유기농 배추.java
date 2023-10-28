import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int arr[][];
	static boolean visit[][];
	static int cnt;
	static int M, N, K;
	static int max;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); //배추밭 가로
			N = Integer.parseInt(st.nextToken()); //배추밭 세로
			K = Integer.parseInt(st.nextToken()); //배추 위치 개수
			arr = new int[M][N];
			visit = new boolean[M][N];
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
			}
			
			cnt = 0;
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					if(arr[j][k]==1 && !visit[j][k]){
						bfs(j, k); //bfs로 출력
						cnt++;
					}
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		visit[x][y] = true;
		queue.offer(new int[] {x, y});
		
		int[] moveX = {0, 0, -1, +1};
		int[] moveY = {-1, +1, 0, 0};
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			
			for(int i=0; i<4; i++) {
				int X = temp[0] + moveX[i];
				int Y = temp[1] + moveY[i];
				
				if(X<0 || X>=M ||Y<0 || Y>=N)
					continue;
				
				else if(arr[X][Y]==1 & !visit[X][Y]) {
					visit[X][Y] = true;
					queue.offer(new int[] {X, Y});
				}
			}
		}
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		
		int[] moveX = {0, 0, -1, +1};
		int[] moveY = {-1, +1, 0, 0};
		
		for(int i=0; i<4; i++) {
			int X = x + moveX[i];
			int Y = y + moveY[i];
			
			if(X<0 || X>=M ||Y<0 || Y>=N)
				continue;
			
			else if(arr[X][Y]==1 & !visit[X][Y]) {
				dfs(X, Y);
			}
		}
	}
}
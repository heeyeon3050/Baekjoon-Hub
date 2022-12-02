package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test16926 {
	static int N, M;
	static int arr[][];
	static int[] dx = {0,1,0,-1}; 
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<R; i++) {
			rotate();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void rotate() {
		int s = Math.min(N, M)/2;
		
		for(int i=0; i<s; i++) {
			int direction = 0; //방향
			int x = i;
			int y = i;
			int temp = arr[x][y];
			while(direction <4) {
				int nx = x + dx[direction];
				int ny = y + dy[direction];
				
				//사각형을 벗어나지 않으면 계속 진행
				if(nx>=i && ny>=i && nx<N-i && ny<M-i) {
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				}
				else
					direction++;
			}
			arr[i+1][i] = temp;
		}
	}
}

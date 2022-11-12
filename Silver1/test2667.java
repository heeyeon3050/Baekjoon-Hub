package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class test2667 {
	static int N;
	static int arr[][];
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static boolean visit[][];
	static ArrayList<Integer> list;
	static int cnt = 1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		visit = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++)
				arr[i][j] = str.charAt(j)-'0';
		}
		
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==1 && !visit[i][j]) {
					cnt = 1;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		sb.append(list.size() + "\n");
		for(int i : list) {
			sb.append(i + "\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		
		//4방향 확인
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(arr[nx][ny]==1 && !visit[nx][ny]) {
					cnt++;
					dfs(nx, ny);
				}
			}
		}
	}
}

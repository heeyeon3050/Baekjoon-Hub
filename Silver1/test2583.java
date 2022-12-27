package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class test2583 {
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int M, N, K;
	static int arr[][];
	static int cnt = 0;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		
		for(int T=0; T<K; T++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=y1; i<y2; i++) {
				for(int j=x1; j<x2; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		list = new ArrayList<Integer>();
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] == 0) {
					cnt = 0;
					dfs(i, j);
					list.add(cnt);
				}
			}
		}
		
		sb.append(list.size() + "\n");
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i) + " ");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int x, int y) {
		arr[x][y] = 1;
		cnt++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && ny>=0 && nx<M && ny<N) {
				if(arr[nx][ny]==0)
					dfs(nx, ny);
			}
		}
	}
}

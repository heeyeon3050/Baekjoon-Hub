package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1018 {
	static boolean arr[][];
	static int min = 32;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<M; j++) {
				if(str.charAt(j) == 'W')
					arr[i][j] = true;
				else 
					arr[i][j] = false;
			}
		}
		
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				find(i, j);
			}
		}
		System.out.println(min);
	}
	
	public static void find(int x, int y) {
		int cnt = 0;
		
		boolean start = arr[x][y];
		
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if(arr[i][j] != start)
					cnt++;
				start = (!start);
			}
			start = (!start);
		}
		
		cnt = Math.min(cnt, 64-cnt);
		min = Math.min(min, cnt);
	}
}

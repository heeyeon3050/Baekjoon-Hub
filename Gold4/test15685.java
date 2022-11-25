package Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test15685 {
	static int N;
	static boolean map[][] = new boolean[101][101];
	static int cnt = 0;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			draw(x, y, getDirections(d, g));
		}
		
		square();
		System.out.println(cnt);
	}
	
	public static ArrayList<Integer> getDirections(int d, int g){
		ArrayList<Integer> directions = new ArrayList<>();
		directions.add(d);
		
		for(int i=0; i<g; i++) {
			for(int j=directions.size()-1; j>=0; j--) {
				int dir = (directions.get(j)+1)%4;
				directions.add(dir);
			}
		}
		return directions;
	}
	
	public static void draw(int x, int y, ArrayList<Integer> directions) {
		map[x][y] = true;
		
		for(int d : directions) {
			switch(d) {
			case 0 :
				map[++x][y] = true;
				break;
			case 1 :
				map[x][--y] = true;
				break;
			case 2 :
				map[--x][y] = true;
				break;
			case 3 :
				map[x][++y] = true;
				break;
			}
		}
	}
	
	public static void square() {
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					cnt++;
			}
		}
	}
}

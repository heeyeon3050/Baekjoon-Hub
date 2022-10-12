package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1063_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		String king = st.nextToken();
		char kingX = king.charAt(0);
		int kingY = king.charAt(1)-'0';
		String stone = st.nextToken();
		char stoneX = stone.charAt(0);
		int stoneY = stone.charAt(1)-'0';
		//          R  L   B  T  RT  LT  RB  LB
		int dx[] = {1, -1, 0, 0, 1, -1, 1, -1};
		int dy[] = {0, 0, -1, 1,1, 1, -1, -1};
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String move = br.readLine();
			int idx = 0;
			char tmpX=kingX;
			int tmpY=kingY;
			switch(move) {
			case "R": idx = 0; break;
			case "L": idx = 1; break;
			case "B": idx = 2; break;
			case "T": idx = 3; break;
			case "RT": idx = 4; break;
			case "LT": idx = 5; break;
			case "RB": idx = 6; break;
			case "LB": idx = 7; break;
			}
			tmpX += dx[idx];
			tmpY += dy[idx];
			
			if(tmpX>='A'&&tmpX<='H' && tmpY>=1&&tmpY<=8) {
				if(tmpX==stoneX && tmpY==stoneY) {
					if(stoneX+dx[idx]>='A'&&stoneX+dx[idx]<='H'
							&& stoneY+dy[idx]>=1&&stoneY+dy[idx]<=8) {
						stoneX += dx[idx];
						stoneY += dy[idx];
					}
					else
						continue;
				}
				kingX = tmpX;
				kingY = tmpY;
			}
		}
		sb.append(kingX).append(kingY).append('\n');
		sb.append(stoneX).append(stoneY);
		
		System.out.println(sb);
	}
}

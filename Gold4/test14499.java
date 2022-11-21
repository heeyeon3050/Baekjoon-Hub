package Gold4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test14499 {
	static int dice[] = new int[7];
	static int map[][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int nx = x + dx[dir-1];
			int ny = y + dy[dir-1];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				
				change(dir);
				
				if(map[nx][ny] == 0) {
					map[nx][ny] = dice[6];
				}
				else {
					dice[6] = map[nx][ny];
					map[nx][ny] = 0;
				}
				
				sb.append(dice[1] + "\n");
				x = nx;
				y = ny;
			}
		}
		
		System.out.println(sb);
	}
	
	public static void change(int dir) {
		int temp[] = dice.clone();
		
		switch(dir) {
		case 1 :
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
			break;
			
		case 2 :
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
			break;
			
		case 3 :
			dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
            break;
           
		case 4 :
			dice[1] = temp[2];
            dice[2] = temp[6];
            dice[5] = temp[1];
            dice[6] = temp[5];
            break;
		}
	}
}

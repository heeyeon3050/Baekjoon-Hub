package Silver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2290 {
	static int s;
	char arr[];
	static int left=0;
	static char board[][];
	static int[][] map = {    { 0, 1, 1, 1, 0, 1, 1, 1 },
            { 0, 0, 0, 1, 0, 0, 1, 0 },
            { 0, 1, 0, 1, 1, 1, 0, 1 },
            { 0, 1, 0, 1, 1, 0, 1, 1 },
            { 0, 0, 1, 1, 1, 0, 1, 0 },
            { 0, 1, 1, 0, 1, 0, 1, 1 },
            { 0, 1, 1, 0, 1, 1, 1, 1 },
            { 0, 1, 0, 1, 0, 0, 1, 0 },
            { 0, 1, 1, 1, 1, 1, 1, 1 },
            { 0, 1, 1, 1, 1, 0, 1, 1 }
        };
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		char arr[] = st.nextToken().toCharArray();
		
		board = new char[2*s+4][arr.length*(s+4)];
		for (int i = 0; i < 2 * s + 3; i++)
            for (int j = 0; j < arr.length * (s + 4); j++)
                board[i][j] = ' ';
		
		for(int i=0; i<arr.length; i++) {
			int n = arr[i] - '0';
			
			if(map[n][1]==1) fill(0, 0, left+1, left+s, '-');
			if (map[n][4] == 1) fill(s + 1, s + 1, left + 1, left + s, '-');
            if (map[n][7] == 1) fill(2 * (s + 1), 2 * (s + 1), left + 1, left + s, '-');
 
            if (map[n][2] == 1) fill(1, s, left, left, '|');
            if (map[n][5] == 1) fill(1 + (s + 1), s + (s + 1), left, left, '|');
 
            if (map[n][3] == 1) fill(1, s, left + s + 1, left + s + 1, '|');
            if (map[n][6] == 1) fill(1 + (s + 1), s + (s + 1), left + s + 1, left + s + 1, '|');
 
            left += s + 3;
        }
		
		for (int i = 0; i < 2 * s + 3; i++) {
            for (int j = 0; j < left; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
		
	}
	
	public static void fill(int sx, int ex, int sy, int ey, char str) {
        for (int x = sx; x <= ex; x++) 
            for (int y = sy; y <= ey; y++) 
                board[x][y] = str;
    }
}

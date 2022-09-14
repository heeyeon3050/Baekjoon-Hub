package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1100 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr[][] = new String[8][8];
		boolean white[][] = new boolean[8][8];
		boolean answer = true;
		
		int cnt=0;
		for(int i=0; i<8; i++) {
			arr[i] = br.readLine().split("");
			for(int j=0; j<8; j++) {
				white[i][j] = (answer);
				answer = (!answer);
			}
			answer = (!answer);
		}
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(arr[i][j].equals("F") && white[i][j])
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}

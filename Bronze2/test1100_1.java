package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1100_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String arr[][] = new String[8][8];
		
		int cnt=0;
		for(int i=0; i<8; i++) {
			arr[i] = br.readLine().split("");
		}
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(arr[i][j].equals("F") && (i+j)%2==0)
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
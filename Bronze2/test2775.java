package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2775 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int floor[][] = new int[k+1][n+1];
			
			for(int j=1; j<=n; j++) {
				floor[0][j] = j;
			}
			
			for(int j=1; j<=k; j++) {
				for(int t=1; t<=n; t++) {
					for(int m=1; m<=t; m++) {
						floor[j][t] += floor[j-1][m];
					}
				}
			}
			
			sb.append(floor[k][n]).append('\n');
		}
		
		System.out.println(sb);
	}
}

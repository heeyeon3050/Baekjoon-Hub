package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test9020 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			boolean check[] = new boolean[n+1];
			check[0] = true;
			check[1] = true;
			
			for(int j=2; j<=Math.sqrt(n); j++) {
				for(int k=j*j; k<=n; k+=j) {
					check[k] = true;
				}
			}
			
			for(int j=n/2; j>1; j--) {
				if(!check[j] && !check[n-j]) {
					sb.append(j).append(" ").append(n-j).append("\n");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}

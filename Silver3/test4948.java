package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test4948 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			
			if(n==0)
				break;
			
			else if(n==1) {
				sb.append(1).append('\n');
			}
			
			else {
				boolean check[] = new boolean[2*n+1];
				check[0] = true;
				check[1] = true;
				int cnt = 0;
				
				for(int i=2; i<=Math.sqrt(2*n); i++) {
					for(int j=i*i; j<=2*n; j+=i) {
						check[j] = true;
					}
				}
				
				for(int i=n+1; i<=2*n; i++) {
					if(!check[i])
						cnt++;
				}
				
				sb.append(cnt).append('\n');
			}
		}
		System.out.println(sb);
	}
}

package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1929 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M; i<=N; i++) {
			
			if(i==1)
				continue;
			
			else {
				int cnt = 0;
				for(int j=2; j<i; j++) {
					if(i%j==0) {
						cnt++;
					}
				}
				if(cnt==0) {
					System.out.println(i);
				}
			}
		}
	}
}

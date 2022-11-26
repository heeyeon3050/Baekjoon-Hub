package Silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test6064 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			boolean check = false;
			
			for(int j=x; j<(N*M)/gcd(N, M); j+=M) {
				if(j % N == y) {
					sb.append(j+1 + "\n");
					check = true;
					break;
				}
			}
			
			if(!check)
				sb.append(-1 + "\n");
		}
		System.out.println(sb);
	}
	
	public static int gcd(int N, int M) {
		int big = 0;
		int small = 0;
		
		if(N > M) {
			big = N;
			small = M;
		}
		else {
			big = M;
			small = N;
		}
		
		int r = big % small;
		if(r == 0)
			return small;
		else
			return gcd(small, r);
	}
}

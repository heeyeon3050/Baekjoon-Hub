package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test25418 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		while(A <= (K/2)) {
			if(K%2 == 1)
				cnt++;
			K/=2;
			cnt++;
		}
		
		if(A!=K)
			cnt += (K-A);
		System.out.println(cnt);
	}
}

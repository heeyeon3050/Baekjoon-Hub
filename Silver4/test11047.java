package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test11047 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int num[] = new int[10];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		
		for(int i=0; i<N; i++) {
			if(num[i]>=K) {
				if(i==1) {
					cnt += K/1;
					K %= 1;
				}
				else {
				cnt += K/num[i-1];
				K %= num[i-1];
				i=0;
				}
			}
			if(K==0)
				break;
		}
		
		/*
		for(int i=N-1; i>=0 && K>0; i--) {
			if(num[i]<=K) {
				cnt += K/num[i];
				K %= num[i];
			}
		}*/
		
		System.out.println(cnt);
		
	}
}

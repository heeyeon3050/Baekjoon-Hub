package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1051_1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		int len = Math.min(N, M);
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		while(len>1) {
			for(int i=0; i<=N-len; i++) {
				for(int j=0; j<=M-len; j++) {
					if(arr[i][j]==arr[i][j+len-1] && arr[i][j]==arr[i+len-1][j]
							&& arr[i][j]==arr[i+len-1][j+len-1]) {
						System.out.println(len*len);
						return;
					}
				}
			}
			len--;
		}
		System.out.println(len*len);
	}
}

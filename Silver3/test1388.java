package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1388 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String arr[][] = new String[N][M];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().split("");
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j].equals("-")) {
					cnt++;
					while(j<M && arr[i][j].equals("-"))
						j++;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(arr[j][i].equals("|")) {
					cnt++;
					while(j<N && arr[j][i].equals("|"))
						j++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}

package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1929_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[N+1];
		StringBuilder sb = new StringBuilder();
		
		//0과 1은 소수가 아니다
		visit[0] = true;
		visit[1] = true;
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			if(!visit[i]) {
				for(int j=i*i; j<=N; j+=i) {
					visit[j] = true;
				}
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(!visit[i])
				sb.append(i).append("\n");
		}
		System.out.println(sb);
	}
}

package Gold5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1107 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken());
			broken[a] = true;
		}
		
		int result = Math.abs(N - 100);
		for(int i=0; i<=999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			
			boolean isBreak = false;
			for(int j=0; j<len; j++) {
				if(broken[str.charAt(j) - '0']) {
					isBreak = true;
					break;
				}
			}
			if(!isBreak) {
				int min = Math.abs(N-i) + len;
				result = Math.min(min, result);
			}
		}
		
		System.out.println(result);
	}
}

package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test1748 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		int length = 1;
		int num = 10;
		for(int i=1; i<=N; i++) {
			if(i == num) {
				length++;
				num *= 10;
			}
			
			answer += length;
		}
		
		System.out.println(answer);
	}
}

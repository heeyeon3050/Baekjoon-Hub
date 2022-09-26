package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test1065_1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int cnt = X;
		
		if(X>=100)
			cnt = 99;
		
		for(int i=100; i<=X; i++) {
			if(i==1000)
				break;
			int a = i/100;
			int b = (i/10)%10;
			int c = i%10;
			if(a-b == b-c) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}

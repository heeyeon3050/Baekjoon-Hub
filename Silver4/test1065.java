package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test1065 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		String num[] = new String[3];
		int cnt = X;
		
		if(X>=100)
			cnt = 99;
		
		for(int i=100; i<=X; i++) {
			if(i==1000)
				break;
			num = String.valueOf(i).split("");
			if(Integer.parseInt(num[0])-Integer.parseInt(num[1]) 
					== Integer.parseInt(num[1])-Integer.parseInt(num[2])) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}

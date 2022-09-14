package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1075 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		
		N /= 100;
		N *= 100;
		
		while(N%100 < 99) {
			if(N%F == 0)
				break;
			N++;
		}
		
		N = N%100;
		if(N<10)
			System.out.println("0"+N);
		else
			System.out.println(N);
	}
}

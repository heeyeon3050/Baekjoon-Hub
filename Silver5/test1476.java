package Silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1476 {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int year = 0;
		int a=0, b=0, c=0;
		while(true) {
			if(a==E && b==S && c==M)
				break;
			else
				year++;
			
			a++;
			b++;
			c++;
			
			if(a == 16) 
				a = 1;
			
			if(b == 29) 
				b = 1;
			
			if(c == 20)
				c = 1;
			
		}
		
		System.out.println(year);
	}
}

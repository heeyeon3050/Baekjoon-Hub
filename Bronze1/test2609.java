package Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2609 {
	public static void main(String[] args) throws IOException{
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      int N = Integer.parseInt(st.nextToken());
	      int M = Integer.parseInt(st.nextToken());
	      
	      System.out.println(gcd(N, M));
	      System.out.println(lcm(N, M));
	}
	
	public static int gcd(int big, int small) {
		if(small == 0) {
			return big;
		}
		
		int r = big % small;
		return gcd(small, r);
	}
	
	public static int lcm(int a, int b) {
		return(a*b)/gcd(a,b);
	}
}

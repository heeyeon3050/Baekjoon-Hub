package Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1934 {
	public static void main(String[] args) throws IOException{
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st;
	      StringBuilder sb = new StringBuilder();
	      int T = Integer.parseInt(br.readLine());
	      
	      for(int i=0; i<T; i++) {
	    	  st = new StringTokenizer(br.readLine());
		      int N = Integer.parseInt(st.nextToken());
		      int M = Integer.parseInt(st.nextToken());
		      
		      sb.append(lcm(N,M) + "\n");
	      }
	      System.out.println(sb);
	}
	
	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		int r = a % b;
		return gcd(b, r);
	}
	
	public static int lcm(int a, int b) {
		return a*b/gcd(a, b);
	}
}

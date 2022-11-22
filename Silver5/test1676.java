package Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1676 {
	static int two = 0;
	static int five = 0;
	public static void main(String[] args) throws IOException{
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int n = Integer.parseInt(br.readLine());
	      int cnt = 0;
	      
	      while(n >= 5) {
	    	  cnt += n/5;
	    	  n /= 5;
	      }
	      System.out.println(cnt);
	}
}

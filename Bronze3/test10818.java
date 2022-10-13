package Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test10818 {
	public static void main(String[] args) throws IOException{
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st;
	      int N = Integer.parseInt(br.readLine());
	      int max = Integer.MIN_VALUE;
	      int min = Integer.MAX_VALUE;
	      st = new StringTokenizer(br.readLine());
	      
	      for(int i=0; i<N; i++) {
	    	  int a = Integer.parseInt(st.nextToken());
	    	  min = Math.min(min, a);
	    	  max = Math.max(max, a);
	      }
	      
	      System.out.println(min + " " + max);
	}
}
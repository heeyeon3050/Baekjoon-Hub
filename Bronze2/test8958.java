package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test8958 {
	public static void main(String[] args) throws IOException{
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringBuilder sb = new StringBuilder();
	      int N = Integer.parseInt(br.readLine());
	      
	      for(int i=0; i<N; i++) {
	    	  int score = 0;
		      int sum = 0;
	    	  String str[] = br.readLine().split("");
	    	  for(int j=0; j<str.length; j++) {
	    		  if(str[j].equals("O")) {
	    			  score++;
	    			  sum += score;
	    		  }
	    		  else
	    			  score=0;
	    	  }
	    	  sb.append(sum).append('\n');
	      }
	      
	      System.out.println(sb);
	}
}

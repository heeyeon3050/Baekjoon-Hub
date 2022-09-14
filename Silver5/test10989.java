package Silver5;

import java.io.*;

public class test10989 {
	public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringBuilder sb = new StringBuilder();
	      int N = Integer.parseInt(br.readLine());
	      int []count = new int[10001];;
	      
	      for(int i=0; i<N; i++) {
	    	  int input = Integer.parseInt(br.readLine());
	    	  count[input]++;
	      }
	      
	      for(int i=1; i<=10000; i++) {
	    	  if(count[i]>0) {
	    		  for(int k=0; k<count[i]; k++) {
	    			  sb.append(i).append("\n");
	    		  }
	    	  }
	      }
	      System.out.println(sb);
	}
}

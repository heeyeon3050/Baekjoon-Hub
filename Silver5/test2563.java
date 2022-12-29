package Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2563 {
	public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st;
	      
	      int n = Integer.parseInt(br.readLine());
	      
	      int arr[][] = new int[101][101];
	      int cnt = 0;
	      for(int i=0; i<n; i++) {
	    	  st = new StringTokenizer(br.readLine());
	    	  int a = Integer.parseInt(st.nextToken());
	    	  int b = Integer.parseInt(st.nextToken());
	    	  
	    	  for(int j=a; j<a+10; j++) {
	    		  for(int k=b; k<b+10; k++) {
	    			  if(arr[j][k] != 1) {
	    				  arr[j][k] = 1;
	    				  cnt++;
	    			  }
	    		  }
	    	  }
	      }
	      System.out.println(cnt);
	}
}

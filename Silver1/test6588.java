package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test6588 {
	static boolean arr[] = new boolean[100001];
	public static void main(String[] args) throws IOException{
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringBuilder sb = new StringBuilder();
	      
	      func();
	      arr[2] = true;
	      while(true){
	    	  int n = Integer.parseInt(br.readLine());
	    	  if(n == 0)
	    		  break;
	    	  
	    	  boolean flag = false;
	    	  for(int i=2; i<=n/2; i++) {
	    		  if(!arr[i] && !arr[n-i]) {
	    			  sb.append(n + " = " + i + " + " + (n-i) + "\n");
	    			  flag = true;
	    			  break;
	    		  }
	    	  }
	    	  if(!flag)
	    		  sb.append("Goldbach's conjecture is wrong." + "\n");
	      }
	      
	      System.out.println(sb);
	}
	
	public static void func() {
		for(int i=2; i*i<=100000; i++) {
			if(!arr[i]) {
			for(int j=i+i; j<=100000; j+=i) 
					arr[j] = true;
			}
		}
	}
}

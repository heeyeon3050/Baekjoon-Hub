package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class test3052 {
	public static void main(String[] args) throws IOException{
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      Set<Integer> set = new HashSet<Integer>();
	      
	      for(int i=0; i<10; i++) {
	    	  int a = Integer.parseInt(br.readLine());
	    	  set.add(a%42);
	      }
	      System.out.println(set.size());
	}
}

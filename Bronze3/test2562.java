package Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test2562 {
	public static void main(String[] args) throws IOException{
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      ArrayList<Integer> list = new ArrayList<>();
	      int max = Integer.MIN_VALUE;
	      
	      for(int i=0; i<9; i++) {
	    	  int a = Integer.parseInt(br.readLine());
	    	  list.add(a);
	    	  max = Math.max(max, a);
	      }
	      System.out.println(max);
	      System.out.println(list.indexOf(max)+1);
	}
}
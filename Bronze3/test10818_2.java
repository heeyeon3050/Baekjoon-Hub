package Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test10818_2 {
	public static void main(String[] args) throws IOException{
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      ArrayList<Integer> list = new ArrayList<>();
	      
	      for(int i=0; i<9; i++) {
	    	  int a = Integer.parseInt(br.readLine());
	    	  list.add(a);
	      }
	      
	      System.out.println(list.indexOf(85));
	}
}
package SILVER5;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class test2751 {
	public static void main(String[] args) {
	      Scanner s = new Scanner(System.in);
	      StringBuilder sb = new StringBuilder();
	      int N = s.nextInt();
	      ArrayList<Integer> list = new ArrayList<>();
	      
	      for(int i=0; i<N; i++)
	    	  list.add(s.nextInt());
	      
	      Collections.sort(list);
	      
	      for(int i : list) {
	    	  sb.append(i).append("\n")	;
	      }
	      System.out.println(sb);
	}
}

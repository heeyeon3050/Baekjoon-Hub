package Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1987 {
	public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st;
	      int N = Integer.parseInt(br.readLine());
	      int arr[] = new int[N];
	      int cnt = 0;
	      
	      st = new StringTokenizer(br.readLine());
	      for(int i=0; i<N; i++) {
	    	  arr[i] = Integer.parseInt(st.nextToken());
	      }
	      
	      Arrays.sort(arr);
	      boolean check[] = new boolean[arr[N-1]+1];
	      
	      check[0] = true;
	      check[1] = true;
	      
	      for(int i=2; i<=Math.sqrt(arr[N-1]); i++) {
	    	  for(int j=i*i; j<=arr[N-1]; j+=i) {
	    		  check[j] = true;
	    	  }
	      }
	      
	      for(int i=0; i<N; i++) {
	    	  if(!check[arr[i]])
	    		  cnt++;
	      }
	      
	      System.out.println(cnt);
	}
}

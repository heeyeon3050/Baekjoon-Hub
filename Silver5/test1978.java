package Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1978 {
	public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st;
	      int N = Integer.parseInt(br.readLine());
	      int arr[] = new int[N];
	      
	      st = new StringTokenizer(br.readLine());
	      for(int i=0; i<N; i++)
	    	  arr[i] = Integer.parseInt(st.nextToken());
	      
	      Arrays.sort(arr);
	      boolean visit[] = new boolean[arr[N-1]+1];
	      
	      visit[0] = true;
	      visit[1] = true;
	      
	      for(int i=2; i<=Math.sqrt(arr[N-1]); i++) {
	    	  for(int j=i*i; j<=arr[N-1]; j+=i) {
	    		  visit[j] = true;
	    	  }
	      }
	      
	      int cnt=0;
	      for(int i=0; i<N; i++) {
	    	  if(!visit[arr[i]])
	    		  cnt++;
	      }
	      System.out.println(cnt);
	}
}

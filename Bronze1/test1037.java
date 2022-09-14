package Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1037 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int N = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(n==1) 
			N = arr[0]*arr[0];
		
		else {
			if(n%2 == 0) 
				N = arr[n/2-1]*arr[n/2];
			
			else
				N = arr[n/2]*arr[n/2];
		}
		System.out.println(N);
	}
}

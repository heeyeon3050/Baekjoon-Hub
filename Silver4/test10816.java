package Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test10816 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int a[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(upperBound(a, key) - lowerBound(a, key)).append(' ');
		}
		
		System.out.println(sb);
	}
	
	static int lowerBound(int[] arr, int key) {
		int start = 0;
		int end = arr.length;
		
		while(start < end) {
			int mid = (start+end)/2;
			
			if(key <= arr[mid]) 
				end = mid;
			
			else
				start = mid + 1;
		}
		return end;
	}
	
	static int upperBound(int[] arr, int key) {
		int start = 0;
		int end = arr.length;
		
		while(start < end) {
			int mid = (start+end) / 2;
			
			if(key < arr[mid])
				end = mid;
			
			else
				start = mid + 1;
		}
		return end;
	}
}

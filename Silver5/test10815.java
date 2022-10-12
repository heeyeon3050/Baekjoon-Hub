package Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test10815 {
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
		int M = Integer.parseInt(br.readLine());
		int b[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		
		
		for(int i=0; i<M; i++) {
			int start = 0;
			int end = N-1;
			int mid = 0;
			boolean check = false;
			
			while(start<=end) {
				mid = (start+end)/2;
				if(a[mid]==b[i]) {
					sb.append(1).append(' ');
					check = true;
					break;
				}
				else if(a[mid]>b[i]) {
					end = mid - 1;
				}
				else
					start = mid + 1;
			}
			
			if(!check)
				sb.append(0).append(' ');
		}
		
		System.out.println(sb);
	}
}

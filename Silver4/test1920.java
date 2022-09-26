package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1920 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int arrN[] = new int[N];
		for(int i=0; i<N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int arrM[] = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrN);
		
		for(int i=0; i<M; i++) {
			int start = 0;
			int end = N-1;
			int mid = 0;
			boolean check = false;
			while(start<=end) {
				mid = (start+end)/2;
				
				if(arrN[mid]==arrM[i]) {
					sb.append(1).append('\n');
					check = true;
					break;
				}
				
				else if(arrN[mid] > arrM[i])
					end = mid-1;
				else
					start = mid+1;
			}
			if(!check)
				sb.append(0).append('\n');
		}
		
		System.out.println(sb);
	}
}

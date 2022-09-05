package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1015 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int order[] = new int[N];
		boolean visit[] = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx = 0;
			
			for(int j=0; j<N; j++) {
				if(visit[j])
					continue;
				
				if(min>arr[j]) {
					min = arr[j];
					minIdx = j;
				}
			}
			
			order[minIdx] = i;
			visit[minIdx] = true;
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(order[i] + " ");
		}
	}
}

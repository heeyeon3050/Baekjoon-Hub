package Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1049 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[1000];
		int min = Integer.MAX_VALUE;
		int min0 = 1000;
		int min1 = 1000;
		int	a = N/6;
		int	b = N%6;
		
		for(int i=0; i<M; i++)	{
			st = new StringTokenizer(br.readLine());
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			min0 = Math.min(min0, arr[0]);
			min1 = Math.min(min1, arr[1]);
		}
		
		min = Math.min(min0*(a+1), min0*a + min1*b);
		min = Math.min(min, min1*N);
		
		System.out.println(min);
	}
}

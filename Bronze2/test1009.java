package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1009 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int arr[] = new int[T];
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int n = 1;
			for(int j=0; j<b; j++)
				n = (a * n) % 10;
			if(n==0)
				n = 10;
			arr[i] = n;
		}
		for(int i=0; i<T; i++)
			System.out.println(arr[i]);
	}
}
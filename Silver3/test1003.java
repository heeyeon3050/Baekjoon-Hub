package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1003 {
	static int cnt1=0, cnt2=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		int fibonacci0[] = new int[41];
		int fibonacci1[] = new int[41];
		String arr[] = new String[c];
		for(int i=0; i<c; i++) {
			cnt1=0;
			cnt2=0;
			int a = Integer.parseInt(br.readLine());
			fibonacci0[0] = 1;
			fibonacci0[1] = 0;
			fibonacci1[0] = 0;
			fibonacci1[1] = 1;
			for(int k=2; k<=a; k++) {
				fibonacci0[k] = fibonacci0[k-1] + fibonacci0[k-2];
				fibonacci1[k] = fibonacci1[k-1] + fibonacci1[k-2];
			}
			arr[i] = fibonacci0[a]+" "+fibonacci1[a];
		}
		for(int i=0; i<c; i++)
			System.out.println(arr[i]);
	}
}
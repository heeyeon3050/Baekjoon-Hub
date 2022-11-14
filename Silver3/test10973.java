package Silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test10973 {
	static int arr[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(func()) {
			for(int a : arr)
				System.out.print(a + " ");
		}
		else
			System.out.println(-1);
		
	}
	
	static public boolean func() {
		int i = arr.length-1;
		while(i>0 && arr[i-1] <= arr[i]) {
			i--;
		}
		if(i<=0)
			return false;
		
		int j = arr.length-1;
		while(arr[i-1] <= arr[j]) {
			j--;
		}
		
		swap(i-1, j);
		j = arr.length-1;
		while(i < j) {
			swap(i, j);
			i++; j--;
		}
		return true;
	}
	
	static public void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}

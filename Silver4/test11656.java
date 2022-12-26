package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test11656 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String arr[] = new String[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.substring(i);
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append('\n');
		}
		
		System.out.println(sb);
	}
}

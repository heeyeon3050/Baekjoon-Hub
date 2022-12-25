package Bronze4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test10808 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int arr[] = new int[123];
		
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i)]++;
		}
		
		for(int i=97; i<123; i++) {
			sb.append(arr[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}

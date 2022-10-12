package Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test1427 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		StringBuilder sb = new StringBuilder();
		String N = br.readLine();
		Character arr[] = new Character[N.length()];
		
		for(int i=0; i<N.length(); i++) {
			arr[i] = N.charAt(i);
		}
		
		Arrays.sort(arr);
		
		for(int i=N.length()-1; i>=0; i--) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb);
	}
}

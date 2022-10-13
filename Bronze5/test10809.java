package Bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test10809 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int arr[] = new int[26];
		
		for(int i=0; i<26; i++) {
			arr[i] = -1;
		}
		
		for(int i=0; i<str.length(); i++) {
			if(arr[str.charAt(i)-'a'] == -1)
				arr[str.charAt(i)-'a'] = i;
		}
		
		for(int i=0; i<26; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
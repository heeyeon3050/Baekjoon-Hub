package Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1543 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String word = br.readLine();
		int cnt = 0;
		int i = 0;
		
		while(i+word.length()<=str.length()) {
			if(str.substring(i, i+word.length()).equals(word)) {
				cnt++;
				i += word.length();
			}
			else
				i += 1;
		}
		System.out.println(cnt);
	}
}
package Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1543_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String word = br.readLine();
		int str_size = str.length();
		int word_size = word.length();
		
		str = str.replace(word,"");
		System.out.println((str_size - str.length())/word_size);
	}
}
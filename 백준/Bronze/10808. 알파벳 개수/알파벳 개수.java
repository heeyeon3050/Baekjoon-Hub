import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		int[] cnt = new int[26];

		int length = str.length();
		for(int i=0; i<length; i++){
			char x = str.charAt(i);
			cnt[x-'a']++;
		}

		for(int i=0; i<26; i++){
			sb.append(cnt[i]).append(" ");
		}

		System.out.println(sb);
	}
}
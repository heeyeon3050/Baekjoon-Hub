import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		int length = str.length();
		for(int i=0; i<length; i++){
			char x = str.charAt(i);
			if((x >= 'A' && x <= 'Z')) {
				sb.append((char)('A' + (x -'A' + 13) % 26));
			}
			else if(x >= 'a' && x <= 'z')
				sb.append((char)('a' + (x - 'a' + 13) % 26));
			else
				sb.append(x);
		}

		System.out.println(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while((str = br.readLine()) != null && !str.isEmpty()){
			int[] cnt = new int[4];
			int length = str.length();
			for(int i=0; i<length; i++){
				char x = str.charAt(i);
				if(x >= 'a' && x <= 'z')
					cnt[0]++;
				else if(x >= 'A' && x <= 'Z')
					cnt[1]++;
				else if(x >= '0' && x<= '9')
					cnt[2]++;
				else
					cnt[3]++;
			}

			for(int i=0; i<4; i++){
				sb.append(cnt[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
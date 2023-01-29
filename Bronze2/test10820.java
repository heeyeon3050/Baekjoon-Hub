package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test10820 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = "";
		
		while((str = br.readLine()) != null) {
			//System.out.println("str : " + str);
			int cnt[] = new int[4];
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == ' ')
					cnt[3]++;
					
				else if(str.charAt(i) >= 97)
					cnt[0]++;
				
				else if(str.charAt(i) >= 65)
					cnt[1]++;
				else
					cnt[2]++;
			}
			
			for(int i=0; i<4; i++) {
				sb.append(cnt[i]).append(' ');
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
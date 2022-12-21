package Bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test10807 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		while(st.hasMoreElements()) {
			if(Integer.parseInt(st.nextToken()) == v) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}

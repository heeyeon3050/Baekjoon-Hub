package Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2525 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		
		if(A+C/60 > 23) {
			A = C/60 - (23-A);
		}
		else
			A += C/60;
		
		if(B+C%60 > 59) {
			B = C%60 - (59-B);
		}
		else
			B += C%60;
		
		sb.append(A).append(" ").append(B);
		System.out.println(sb);
	}
}

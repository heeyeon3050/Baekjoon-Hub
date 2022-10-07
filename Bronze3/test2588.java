package Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2588 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		sb.append(a * (b%10)).append('\n');
		sb.append(a*((b/10)%10)).append('\n');
		sb.append(a * (b/100)).append('\n');
		
		sb.append(a*b);
		System.out.println(sb);
	}
}

package Bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test11653 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int i=2;
		
		if(N==1)
			sb.append("");
		else {
			while(i <= N) {
				if(N%i==0) {
					N/=i;
					sb.append(i).append('\n');
				}
				else
					i++;
			}
		}
		
		System.out.println(sb);
	}
}
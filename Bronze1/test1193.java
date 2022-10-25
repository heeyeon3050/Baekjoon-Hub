package Bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test1193 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a = 0, b = 0;
		int sum = 0;
		int i = 0;
		int cnt = 0;
		
		while(sum < X) {
			sum += (i+1);
			i++;
		}
		
		if(i%2==0) {
			sb.append(i-(sum-X)).append('/').append(sum-X+1);
		}
		else
			sb.append(sum-X+1).append('/').append(i-(sum-X));
		
		System.out.println(sb);
	}
}

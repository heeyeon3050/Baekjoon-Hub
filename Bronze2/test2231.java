package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2231 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int length = (int)(Math.log10(N)+1);
		int result = 0;
		
		for(int i=N-(9*length); i<=N; i++) {
			int num = i;
			int sum = i;
			while(num > 0) {
				sum += (num%10);
				num /= 10;
				if(sum > N)
					break;
			}
			if(sum == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}

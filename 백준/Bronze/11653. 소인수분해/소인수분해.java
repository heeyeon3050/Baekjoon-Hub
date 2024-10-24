import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for(int i=2; i*i<=n; i++){
			while(n % i == 0){
				sb.append(i).append("\n");
				n /= i;
			}
		}

		if(n != 1) //n이 소수인 경우에는 나누어 떨어지지 않으므로
			sb.append(n);

		System.out.println(sb);
	}
}
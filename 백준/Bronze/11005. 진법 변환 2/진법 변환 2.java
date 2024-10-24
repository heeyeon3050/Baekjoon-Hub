import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		while(n != 0){
			int remainder = n % b;
			n = n / b;

			if(remainder >= 10){
				sb.append((char)('A'+(remainder - 10)));
			} else {
				sb.append(remainder);
			}
		}

		System.out.println(sb.reverse());
	}
}
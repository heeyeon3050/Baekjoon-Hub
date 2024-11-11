import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		boolean[] broken = new boolean[10];
		if(m > 0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++){
				int a = Integer.parseInt(st.nextToken());
				broken[a] = true;
			}
		}

		int min = Math.abs(n - 100);
		for(int i=0; i<=999999; i++){
			String num = String.valueOf(i);

			boolean flag = false;
			for(int j=0; j<num.length(); j++){
				if(broken[num.charAt(j) - '0']){
					flag = true;
					break;
				}
			}

			if(!flag){
				min = Math.min(min, Math.abs(n - i) + num.length());
			}
		}

		System.out.println(min);
	}
}
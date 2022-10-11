package Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2884 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(M<45) {
			M += 15;
			if(H==0)
				H = 23;
			else
				H -= 1;
		}
		
		else
			M -= 45;
		
		sb.append(H).append(" ").append(M);
		System.out.println(sb);
	}
}

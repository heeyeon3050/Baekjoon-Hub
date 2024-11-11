import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++){

			st = new StringTokenizer(br.readLine());
			int	m = Integer.parseInt(st.nextToken());
			int	n = Integer.parseInt(st.nextToken());
			int	x = Integer.parseInt(st.nextToken());
			int	y = Integer.parseInt(st.nextToken());

			int result = -1;
			for(int i=x; i<=n*m; i+=m){ //기본으로 m씩 증가하여 (i%m == x) 만족시킬 수 있도록 설정
				if((i-1) % n + 1 == y){
					result = i;
					break;
				}
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int sum = 0;
		int index = n;
		boolean[] select = new boolean[n+1];

		while (index > 0) {
			if (sum + index-1 <= k) {
				sum += index-1;
				select[index] = true;
			}
			index--;
		}

		for (int i = n; i > 0; i--) {
			if (select[i]) {
				sb.append(i).append(" ");
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!select[i]) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb);
	}
}

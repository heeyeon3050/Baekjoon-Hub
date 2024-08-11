import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			long answer = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				arr[j] = Integer.parseInt(st.nextToken());

			int max = arr[n-1];    //마지막 값으로 설정
			for (int j = n-2; j >= 0; j--) {
				if (arr[j] <= max)    //가장 큰 시세보다 작은 시세일 때 판매
					answer += max - arr[j];
				else
					max = arr[j];
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int sum = n+m;
		int[] arr = new int[sum];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=n; i<sum; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for(int i=0; i<sum; i++){
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb);
	}
}
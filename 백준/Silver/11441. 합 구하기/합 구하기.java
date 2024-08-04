import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];

		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++){
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum;
		}

		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(arr[b] - arr[a-1]).append("\n");
		}

		System.out.println(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[] arr = new long[n+1];
		long[] cnt = new long[m];

		long sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++){
			sum += Integer.parseInt(st.nextToken());
			arr[i] = sum % m;

			cnt[(int)arr[i]]++;
		}

		long result = cnt[0];
		for(int i=0; i<m; i++){
			if(cnt[i] > 1){
				result += (cnt[i] * (cnt[i]-1)) / 2;
			}
		}

		System.out.println(result);
	}
}
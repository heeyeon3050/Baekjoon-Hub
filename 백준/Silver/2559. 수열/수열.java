import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] += sum[i-1] + arr[i];
		}
		
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i=K; i<=N; i++) {
			int result = sum[i] - sum[index++];
			if(max < result) {
				max = result;
			}
		} 
		
		System.out.println(max);
	}
}
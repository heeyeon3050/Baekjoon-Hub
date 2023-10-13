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
		int[] cnt = new int[100001];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0, right = 0;
		int max = Integer.MIN_VALUE;
		while(right < N) {
			cnt[arr[right]]++;
			while(cnt[arr[right]] > K) {
				cnt[arr[left++]]--;
			}
			
			int result = right - left + 1;
			max = Math.max(max, result);
			right++;
		}
		System.out.println(max);
	}
}
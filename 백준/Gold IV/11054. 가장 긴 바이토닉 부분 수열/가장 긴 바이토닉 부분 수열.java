import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		int dp1[] = new int[N+1];
		int dp2[] = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			dp1[i] = 1;
			for(int j=1; j<i; j++) {
				if(arr[i] > arr[j] && dp1[i] <= dp1[j]) {
					dp1[i] = dp1[j] + 1;
				}
			}
		}
		
		for(int i=N; i>=1; i--) {
			dp2[i] = 1;
			for(int j=N; j>i; j--) {
				if(arr[i] > arr[j] && dp2[i] <= dp2[j]) {
					dp2[i] = dp2[j] + 1;
				}
			}
		}
		
		int max = -1;
		for(int i=1; i<=N; i++)
			max = Math.max(max, dp1[i]+dp2[i]);
		
		System.out.println(max-1);
	}
}
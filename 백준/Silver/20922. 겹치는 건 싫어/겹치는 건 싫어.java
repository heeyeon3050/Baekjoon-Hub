import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] cnt = new int[100001];

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int max = 0;
		while(end < n){
			if(cnt[arr[end]] < k){
				cnt[arr[end]]++;
				end++;
			} else {
				cnt[arr[start]]--;
				start++;
			}
			max = Math.max(max, end - start);
		}

		System.out.println(max);
	}
}
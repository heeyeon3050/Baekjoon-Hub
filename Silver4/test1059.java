package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1059 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L = Integer.parseInt(br.readLine());
		int arr[] = new int[L];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int n = Integer.parseInt(br.readLine());
		int cnt=0;
		
		if(n<arr[0]) { //n이 S에서 제일 작은 수 보다 작을 경우도 생각
			cnt += arr[0]-1-n;
			cnt += (n-1)*(arr[0]-n);
		}
		else {
			for(int i=0; i<L-1; i++) {
				int a = arr[i]+1;
				int b = arr[i+1]-1;
				if(a<=n && b>=n) {
					cnt += b-n;
					cnt += (n-a)*(b-n+1);
				}
			}
		}
		
		System.out.println(cnt);
		
	}
}

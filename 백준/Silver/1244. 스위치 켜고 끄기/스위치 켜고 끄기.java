import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];

		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(a == 1)
				boy(b);
			else
				girl(b);
		}

		for(int i=1; i<=n; i++){
			sb.append(arr[i]).append(" ");
			if(i % 20 == 0)
				sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void boy(int num){
		for(int i=num; i<=n; i+=num){
			if(arr[i] == 1)
				arr[i] = 0;
			else
				arr[i] = 1;
		}
	}

	public static void girl(int num){
		int start = num;
		int end = num;

		for(int i=1; i<n; i++){
			if(num-i <= 0 || num+i > n)
				break;
			if(arr[num-i] == arr[num+i]) {
				start = num - i;
				end = num + i;
			}
			else
				break;
		}

		for(int i=start; i<=end; i++){
			if(arr[i] == 1)
				arr[i] = 0;
			else
				arr[i] = 1;
		}
	}
}
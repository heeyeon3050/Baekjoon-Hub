import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		for(int i=0; i<x; i++){
			sum += arr[i];
		}

		int cnt = 1;
		int max = sum;
		for(int i=0; i+x<n; i++){
			sum -= arr[i];
			sum += arr[i+x];
			if(max == sum){
				cnt++;
			} else if(max < sum){
				max = sum;
				cnt = 1;
			}
		}

		if(max == 0)
			System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
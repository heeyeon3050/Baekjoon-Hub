import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int start = 0;
		int end = arr[arr.length-1];

		while(start < end){
			int mid = (start + end) / 2;

			if(func(arr, n, mid) < m)
				end = mid;
			else {
				start = mid + 1;
			}
		}

		System.out.println(start-1);
	}

	public static long func(int[] arr, int n, int mid){
		long sum = 0;
		for(int i=0; i<n; i++){
			if(arr[i] > mid){
				sum += arr[i] - mid;
			}
		}
		return sum;
	}
}
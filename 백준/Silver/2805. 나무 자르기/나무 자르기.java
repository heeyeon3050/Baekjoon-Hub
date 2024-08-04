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
		long m = Long.parseLong(st.nextToken());

		long[] arr = new long[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		System.out.println(upperBound(arr, m)-1);
	}

	public static long upperBound(long[] arr, long m){
		long start = 0;
		long end = arr[arr.length-1];

		while(start < end){
			long mid = (start + end) / 2;

			if(height(arr, mid) >= m){
                start = mid + 1;
			} else
				end = mid;
		}

		return start;
	}

	public static long height(long[] arr, long mid){
		long n = arr.length;

		long sum = 0;
		for(int i=0; i<n; i++){
			if(arr[i] > mid)
				sum += arr[i] - mid;
		}

		return sum;
	}
}
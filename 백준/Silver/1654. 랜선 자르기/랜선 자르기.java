import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, k = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		int[] arr = new int[k];
		for(int i=0; i<k; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		System.out.println(upperBound(arr)-1);
	}

	public static long upperBound(int[] arr){
		long start = 1;
		long end = 2_222_222_222L;

		while(start < end){
			//int mid = (start + end) / 2;
			long mid = start + (end - start) / 2;
			if(func(arr, mid) >= n){
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return start;
	}

	public static int func(int[] arr, long mid){
		int num = 0;
		for(int i=0; i<k; i++){
			num += arr[i]/mid;
		}

		return num;
	}
}
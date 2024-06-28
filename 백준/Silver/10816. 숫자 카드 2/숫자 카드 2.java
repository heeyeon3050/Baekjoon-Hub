import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++){
			int num = Integer.parseInt(st.nextToken());

			int lower = lowerBound(arr, num);
			int upper = upperBound(arr, num);

			sb.append(upper-lower).append(" ");
		}

		System.out.println(sb);
	}

	public static int lowerBound(int[] arr, int card){
		int start = 0;
		int end = arr.length;

		while(start < end){
			int mid = (start + end) / 2;

			if(arr[mid] >= card){
				end = mid;
			} else
				start = mid + 1;
		}

		return start;
	}

	public static int upperBound(int[] arr, int card){
		int start = 0;
		int end = arr.length;

		while(start < end){
			int mid = (start + end) / 2;

			if(arr[mid] > card){
				end = mid;
			} else
				start = mid + 1;
		}

		return start;
	}
}
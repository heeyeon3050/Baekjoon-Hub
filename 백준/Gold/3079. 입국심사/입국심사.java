import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		System.out.println(lowerBound());
	}

	public static long lowerBound(){
		long start = 0;
		long end = (long)Math.pow(10, 9) * m;

		while(start < end){
			long mid = (start + end) / 2;

			long sum = 0;
			for(int a : arr){
				sum += mid/a;
				if(sum >= m)
					break;
			}

			if(sum >= m)
				end = mid;
			else
				start = mid + 1;
		}

		return start;
	}
}
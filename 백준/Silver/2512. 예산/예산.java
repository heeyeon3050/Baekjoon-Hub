import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		m = Integer.parseInt(br.readLine());

		System.out.println(upperBound()-1);
	}

	public static int upperBound(){
		int start = 0;
		int end = max + 1;

		while(start < end){
			int mid = (start+end) / 2;

			if(func(mid) <= m){
				start = mid+1;
			}else {
				end = mid;
			}
		}
		return start;
	}

	public static long func(int mid){
		long sum = 0;
		for(int i=0; i<n; i++){
			if(arr[i] > mid){
				sum += mid;
			} else {
				sum += arr[i];
			}
		}
		return sum;
	}
}
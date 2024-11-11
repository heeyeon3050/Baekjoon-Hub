import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		arr = new int[n];
		visit = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		recur(0, new int[n]);

		System.out.println(max);
	}

	public static void recur(int depth, int[] num){
		if(depth == n){
			max = Math.max(max, calculate(num));
			return;
		}

		for(int i=0; i<n; i++){
			num[depth] = arr[i];
			if(!visit[i]) {
				visit[i] = true;
				recur(depth + 1, num);
				visit[i] = false;
			}
		}
	}

	public static int calculate(int[] arr){
		int length = arr.length;
		int sum = 0;

		for(int i=0; i<length-1; i++){
			sum += Math.abs(arr[i] - arr[i+1]);
		}
		return sum;
	}
}
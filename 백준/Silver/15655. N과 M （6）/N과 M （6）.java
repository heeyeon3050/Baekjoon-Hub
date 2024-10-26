import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	public static int[] num;
	public static int[] arr;
	public static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		arr = new int[m];
		visit = new boolean[n];
		recur(0, 0);

		System.out.println(sb);
	}

	public static void recur(int depth, int start){
		if(depth == m){
			for(int a : arr)
				sb.append(a).append(" ");
			sb.append("\n");
			return;
		}

		for(int i=start; i<n; i++){
			arr[depth] = num[i];
			recur(depth + 1, i+1);
		}
	}
}
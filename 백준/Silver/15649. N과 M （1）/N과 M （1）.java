import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[] arr = new int[m];
		boolean[] visit = new boolean[10];
		recur(0, arr, visit);

		System.out.println(sb);
	}

	public static void recur(int depth, int[] arr, boolean[] visit){
		if(depth == m){
			for(int a : arr)
				sb.append(a).append(" ");
			sb.append("\n");
			return;
		}

		for(int i=1; i<=n; i++){
			if(!visit[i]) {
				arr[depth] = i;
				visit[i] = true;
				recur(depth + 1, arr, visit);
				visit[i] = false;
			}
		}
	}
}
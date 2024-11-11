import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visit = new boolean[n];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<n; i++){
			visit[i] = true;
			dfs(0, i, i, 0);
			visit[i] = false;
		}

		System.out.println(min);
	}

	public static void dfs(int depth, int start, int now, int sum){
		if(depth == n-1){
			if(arr[now][start] != 0){
				sum += arr[now][start];
				min = Math.min(min, sum);
			}
			return;
		}

		for(int i=0; i<n; i++){
			if(!visit[i] && arr[now][i] > 0){
				visit[i] = true;
				dfs(depth+1, start, i, sum + arr[now][i]);
				visit[i] = false;
			}
		}
	}
}
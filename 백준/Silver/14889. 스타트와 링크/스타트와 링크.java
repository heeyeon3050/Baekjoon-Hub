import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[][] arr;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0, new boolean[n]);

		System.out.println(min);
	}

	public static void dfs(int depth, int start, boolean[] num){
		if(depth == n/2){
			min = Math.min(min, calculate(num));
			return;
		}

		for(int i=start; i<n; i++){
			num[i] = true;
			dfs(depth+1, i+1, num);
			num[i] = false;
		}
	}

	public static int calculate(boolean[] num){
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<n-1; i++){
			for(int j=i+1; j<n; j++){
				if(num[i] && num[j]){
					sum1 += arr[i][j];
					sum1 += arr[j][i];
				} else if(!num[i] && !num[j]){
					sum2 += arr[i][j];
					sum2 += arr[j][i];
				}
			}
		}

		return Math.abs(sum1 - sum2);
	}
}
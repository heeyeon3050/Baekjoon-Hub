import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[][] dp1;
	static int[][] dp2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		arr = new int[n+1][4];
		dp1 = new int[n+1][4];
		dp2 = new int[n+1][4];

		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=3; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=1; i<=n; i++){
			dp1[i][1] = Math.max(dp1[i-1][1], dp1[i-1][2]) + arr[i][1];
			dp1[i][2] = Math.max(Math.max(dp1[i-1][1], dp1[i-1][2]), dp1[i-1][3]) + arr[i][2];
			dp1[i][3] = Math.max(dp1[i-1][2], dp1[i-1][3]) + arr[i][3];

			dp2[i][1] = Math.min(dp2[i-1][1], dp2[i-1][2]) + arr[i][1];
			dp2[i][2] = Math.min(Math.min(dp2[i-1][1], dp2[i-1][2]), dp2[i-1][3]) + arr[i][2];
			dp2[i][3] = Math.min(dp2[i-1][2], dp2[i-1][3]) + arr[i][3];
		}

		int max = Math.max(Math.max(dp1[n][1], dp1[n][2]), dp1[n][3]);
		int min = Math.min(Math.min(dp2[n][1], dp2[n][2]), dp2[n][3]);

		System.out.println(max + " " + min);
	}
}
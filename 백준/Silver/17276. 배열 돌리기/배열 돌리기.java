import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr, copy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++){

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if(d < 0)
				d += 360;
			d /= 45;

			arr = new int[n][n];
			copy = new int[n][n];
			for(int i=0; i<n; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
					copy[i][j] = arr[i][j];
				}
			}

			for(int i=0; i<d; i++) {
				rotate();
			}

			for(int[] ar : arr){
				for(int a : ar){
					sb.append(a + " ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);
	}

	private static void rotate() {
		for(int i = 0; i < n ; i++){
			copy[i][n/2] = arr[i][i];
			copy[i][i] = arr[n/2][i];
			copy[n/2][i] = arr[n-i-1][i];
			copy[n-i-1][i] = arr[n-i-1][n/2];
		}

		for(int i = 0; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				arr[i][j] = copy[i][j];
			}
		}
	}
}
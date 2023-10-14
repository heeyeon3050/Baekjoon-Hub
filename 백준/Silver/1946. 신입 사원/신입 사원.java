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
		int T = Integer.parseInt(br.readLine());


		for(int tc=0; tc<T; tc++){
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];

			for(int i=0; i<N; i++){
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, (int[] o1, int[] o2) -> {
				return Integer.compare(o1[0], o2[0]);
			});

			int cnt = 1;
			int score = arr[0][1];
			for(int i=0; i<N; i++){
				if(arr[i][1] < score){
					score = arr[i][1];
					cnt++;
				}
			}

			sb.append(cnt + "\n");
		}

		System.out.println(sb);

	}
}
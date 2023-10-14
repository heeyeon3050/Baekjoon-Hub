import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static StringBuilder sb;
	static int[] num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[M];
		per(0);

		System.out.println(sb);
	}

	private static void per(int n){
		if(n == M){
			for(int i=0; i<M; i++)
				sb.append(num[i] + " ");
			sb.append("\n");
			return;
		}

		for(int i=0; i<N; i++){
			num[n] = i+1;
			per(n+1);
		}
	}
}
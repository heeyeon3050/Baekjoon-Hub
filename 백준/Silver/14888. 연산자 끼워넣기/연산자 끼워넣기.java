import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr, operator;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		operator = new int[4];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++){
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(1, arr[0]);

		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int n, int num){
		if(n == N){
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		for(int i=0; i<4; i++){

			if(operator[i] == 0)
				continue;

			operator[i]--;

			switch (i){
				case 0 : dfs(n+1, num + arr[n]); break;
				case 1 : dfs(n+1, num - arr[n]); break;
				case 2 : dfs(n+1, num * arr[n]); break;
				case 3 : dfs(n+1, num / arr[n]); break;
			}

			operator[i]++;
		}
	}
}
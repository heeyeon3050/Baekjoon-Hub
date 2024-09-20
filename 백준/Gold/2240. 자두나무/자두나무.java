import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int t, w;
	static int[] arr;
	static int[][][] dp;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		t = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		arr = new int[t];
		dp = new int[t][w+1][3];
		for(int i=0; i<t; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i=0; i<t; i++){
			for(int j=0; j<=w; j++){
				dp[i][j][1] = -1;
				dp[i][j][2]	= -1;
			}
		}

		max = Math.max(dfs(0, 0, 1), dfs(0, 1, 2));

		System.out.println(max);
	}

	public static int dfs(int time, int move, int tree){
		if(time == t) {
			return 0;
		}

		if (dp[time][move][tree] != -1)
			return dp[time][move][tree];

		int plum = (arr[time] == tree) ? 1 : 0; //현재 나무에서 자두를 줍는 경우

		int a = dfs(time+1, move, tree); //1.현재 나무에 그대로 있는 경우

		int b = 0;
		if(move < w)
			b = dfs(time+1, move+1,3 - tree); //2.나무 번호를 바꾼 경우

		return dp[time][move][tree] = plum + Math.max(a, b);
	}
}
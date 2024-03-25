import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean visit[];
	static int num[];
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		num = new int[N];
		
		dfs(0, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int x, int cnt) {
		if(cnt == N) {
			for(int n : num) {
				sb.append(n + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				num[x] = i;
				dfs(x+1, cnt+1);
				visit[i] = false;
			}
		}
	}
}

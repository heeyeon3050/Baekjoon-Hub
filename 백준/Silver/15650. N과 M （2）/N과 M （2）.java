import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean [N+1];
		dfs(1, 0);
		
		System.out.println(sb);
	}
	
	public static void dfs(int x, int cnt) {
		if(cnt == M) {
			for(int i=1; i<=N; i++) {
				if(visit[i])
					sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=x; i<=N; i++) {
			visit[i] = true;
			dfs(i+1, cnt+1);
			visit[i] = false;
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] visited;
	static List<Integer>[] graph;
	// dp : 해당 지점까지의 얼리어답터 인원수(트리 구조이기 때문에 자식 노드들의 dp개수를 더해온다)
	static int[][] dp;	// [y][x]일 때, y : 노드 번호, x : 0 -> 해당 노드번호가 earlyAdaptor가 아닐때, 1 -> 해당 노드번호가 earlyAdaptor일 때

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.valueOf(br.readLine());
		dp = new int[n+1][2];
		visited = new boolean[n+1];
		graph = new ArrayList[n+1];
		for(int i=0; i<=n; i++){
			graph[i] = new ArrayList<>();
		}

		for(int i=1; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		//트리 구조이기 때문에 1부터 시작
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	public static void dfs(int number){
		visited[number] = true;
		dp[number][0] = 0;	//얼리어답터가 아닌 경우
		dp[number][1] = 1;	//얼리어답터인 경우(해당 지점이 얼리어답터이기 때문에 1로 시작)

		for(int child : graph[number]){
			if(!visited[child]){
				dfs(child);
				dp[number][0] += dp[child][1];
				dp[number][1] += Math.min(dp[child][0], dp[child][1]);
			}
		}
	}
}
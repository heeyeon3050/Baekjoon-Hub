import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, b;
	static int[][] arr;
	static boolean[] visit;
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
	
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		dfs(a, 0);
		
		System.out.println(answer);
	}
	
	private static void dfs(int num, int cnt) {
		visit[num] = true;
		
		if(num == b) {
			answer = cnt;
			return;
		}
		
		for(int i=1; i<=n; i++) {
			if(!visit[i] && arr[num][i] == 1) {
				dfs(i, cnt+1);
			}
		}
	}
}
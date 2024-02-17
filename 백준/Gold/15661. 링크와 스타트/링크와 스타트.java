import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int t;
	static int S[][];
	static boolean visit[];
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st;
		  N = Integer.parseInt(br.readLine());
		  
		  S = new int[N][N];
		  visit = new boolean[N];
		  
		  for(int i=0; i<N; i++) {
			  st = new StringTokenizer(br.readLine());
			  for(int j=0; j<N; j++) {
				  S[i][j] = Integer.parseInt(st.nextToken());
			  }
		  }
		  
		  for(t=1; t<N; t++)
			  dfs(0, 0);
		  System.out.println(min);
	}
	
	public static void dfs(int idx, int cnt) {
		if(cnt==t) {
			diff();
			return;
		}
		
		for(int i=idx; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i+1, cnt+1);
				visit[i] = false;
			}
		}
	}
	
	public static void diff() {
		int team_start = 0;
		int team_link = 0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(visit[i]==true && visit[j]==true) {
					team_start += S[i][j];
					team_start += S[j][i];
				}
				else if(visit[i]==false && visit[j]==false){
					team_link += S[i][j];
					team_link += S[j][i];
				}
			}
		}
		
		int val = Math.abs(team_start - team_link);
		
		if(val == 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		min = Math.min(min, val);
	}
}
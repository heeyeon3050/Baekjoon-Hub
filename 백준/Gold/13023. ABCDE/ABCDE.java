import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st = new StringTokenizer(br.readLine());
		  
		  int N = Integer.parseInt(st.nextToken());
		  int M = Integer.parseInt(st.nextToken());
		  
		  list = new ArrayList[N];
		  for(int i=0; i<N; i++) {
			  list[i] = new ArrayList<>();
		  }
		  
		  for(int i=0; i<M; i++) {
			  st = new StringTokenizer(br.readLine());
			  int a = Integer.parseInt(st.nextToken());
			  int b = Integer.parseInt(st.nextToken());
			  list[a].add(b);
			  list[b].add(a);
		  }
		  
		  for(int i=0; i<N; i++) {
			  visited = new boolean[N];
			  dfs(i, 0);
			  
			  if(answer == 1)
				  break;
		  }
		  
		  System.out.println(answer);
	}
	
	public static void dfs(int x, int len) {
		if(len == 4) {
			answer = 1;
			return;
		}
		
		visited[x] = true;
		for(int i=0; i<list[x].size(); i++	) {
			int temp = list[x].get(i);
			if(visited[temp] == false) {
				visited[temp] = true;
				dfs(temp, len + 1);
				visited[temp] = false;
			}
		}
	}
}
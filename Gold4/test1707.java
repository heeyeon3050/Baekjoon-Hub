package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test1707 {
	static int V;
	static ArrayList<Integer> list[];
	static int visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];
			visit = new int[V+1];
			
			for(int j=0; j<=V; j++) {
				list[j] = new ArrayList<>();
			}
			
			for(int j=0; j<E; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list[a].add(b);
				list[b].add(a);
			}
			bfs();
		}
		System.out.println(sb);
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<V+1; i++) {
			if(visit[i] == 0) {
				queue.add(i);
				visit[i] = 1;
			}
			
			while(!queue.isEmpty()) {
				int now = queue.poll();
				for(int j=0; j<list[now].size(); j++) {
					if(visit[list[now].get(j)] == 0) {
						queue.offer(list[now].get(j));
						
						if(visit[now]==1)
							visit[list[now].get(j)] = 2;
						else
							visit[list[now].get(j)] = 1;
					}
					
					else if(visit[list[now].get(j)] == visit[now]) {
						sb.append("NO" + "\n");
						return;
					}
				}
			}
		}
		sb.append("YES" + "\n");
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] indegree;
	static List<Integer>[] list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		indegree = new int[n+1];
		list = new List[n+1];

		for(int i=1; i<=n; i++){
			list[i] = new ArrayList<>();
		}

		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			indegree[b]++;
		}

		topologySort();

		System.out.println(sb);
	}

	public static void topologySort(){
		Queue<Integer> pq = new PriorityQueue<>();

		for(int i=1; i<=n; i++){
			if(indegree[i] == 0){
				pq.offer(i);
			}
		}

		while(!pq.isEmpty()){
			int now = pq.poll();
			sb.append(now).append(" ");

			for(int i : list[now]){
				indegree[i]--;

				if(indegree[i] == 0){
					pq.offer(i);
				}
			}
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, l;
	static int[] indegree, drug;
	static List<Integer>[] list;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		indegree = new int[m];
		drug = new int[m];
		list = new List[n+1];
		visit = new boolean[n+1];

		for(int i=1; i<=n; i++){
			list[i] = new ArrayList<>();
		}

		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());

			for(int j=0; j<k; j++){
				int a = Integer.parseInt(st.nextToken());
				list[a].add(i);
			}

			indegree[i] = k;
			int r = Integer.parseInt(st.nextToken());
			drug[i] = r;
		}

		l = Integer.parseInt(br.readLine());

		int[] liquid = new int[l];

		st = new StringTokenizer(br.readLine());

		for(int i=0; i<l; i++){
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		topologySort(liquid);

		System.out.println(sb);
	}

	public static void topologySort(int[] liquid){
		List<Integer> result = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();

		for(int i=0; i<l; i++){
			queue.offer(liquid[i]);
			visit[liquid[i]] = true;
		}

		while (!queue.isEmpty()){
			int now = queue.poll();
			result.add(now);

			for(int i : list[now]){
				indegree[i]--;
				if(indegree[i] == 0 && !visit[drug[i]]){
					queue.offer(drug[i]);
					visit[drug[i]] = true;
				}
			}
		}

		Collections.sort(result);
		sb.append(result.size()).append("\n");

		for(int i : result){
			sb.append(i).append(" ");
		}
	}
}
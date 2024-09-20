import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static List<Integer>[] list;
	static int[] parent;
	static int[] time;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n+1];
		for(int i=0; i<=n; i++){
			list[i] = new ArrayList<>();
		}

		time = new int[n+1];
		parent = new int[n+1];

		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true){
				int b = Integer.parseInt(st.nextToken());
				if(b == -1)
					break;
				list[b].add(i);
				parent[i]++;
			}
		}

		topologySort();

		for(int i=1; i<=n; i++){
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}

	public static void topologySort(){
		Queue<Integer> queue = new ArrayDeque<>();
		answer = new int[n+1];

		for(int i=1; i<=n; i++){
			if(parent[i] == 0){
				queue.add(i);
				answer[i] = time[i];
			}
		}

		while(!queue.isEmpty()){
			int size = queue.size();

			for(int i=0; i<size; i++){
				int now = queue.poll();

				for(int next : list[now]){
					answer[next] = Math.max(answer[next], answer[now] + time[next]);

					if(--parent[next] == 0){
						queue.add(next);
					}
				}
			}
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {

	public static class DSLR{
		int num;
		String order;

		public DSLR(int num, String order){
			this.num = num;
			this.order = order;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			boolean[] visit = new boolean[10000];
			String[] command = new String[10000];
			Arrays.fill(command, "");

			Queue<Integer> queue = new LinkedList<>();
			queue.add(a);
			visit[a] = true;

			while(!queue.isEmpty()){
				int now = queue.poll();

				int D = (2 * now) % 10000;
				int S = now == 0 ? 9999 : now - 1;
				int L = (now % 1000) * 10 + now / 1000;
				int R = (now % 10) * 1000 + now / 10;

				if(!visit[D]){
					queue.add(D);
					visit[D] = true;
					command[D] = command[now] + "D";
				}
				if(!visit[S]){
					queue.add(S);
					visit[S] = true;
					command[S] = command[now] + "S";
				}
				if(!visit[L]){
					queue.add(L);
					visit[L] = true;
					command[L] = command[now] + "L";
				}
				if(!visit[R]){
					queue.add(R);
					visit[R] = true;
					command[R] = command[now] + "R";
				}
			}
			sb.append(command[b]).append("\n");
		}
		System.out.println(sb);
	}
}
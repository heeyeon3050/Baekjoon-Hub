import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] order;
	static List<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		order = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		if(order[0] != 1) {
			System.out.println(0);
			return;
		}

		if (bfs()) {
			System.out.println(1);
		} else
			System.out.println(0);
	}

	private static boolean bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N + 1];
		queue.offer(1);
		visit[1] = true;

		int index = 1;
		while (!queue.isEmpty()) {
			int a = queue.poll();

			int cnt = 0;
			for (int l : list[a]) {
				if (!visit[l]) {
					visit[l] = true;
					cnt++;
				}
			}

			for (int i = index; i < index + cnt; i++) {
				if (visit[order[i]]) {
					queue.offer(order[i]);
				} else
					return false;
			}
			index += cnt;
		}
		return true;
	}
}
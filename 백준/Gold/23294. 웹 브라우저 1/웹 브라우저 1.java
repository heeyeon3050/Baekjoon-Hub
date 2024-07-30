import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int cap[] = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			cap[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> back = new ArrayDeque<>();
		Deque<Integer> front = new ArrayDeque<>();

		int now = -1;
		int front_size = 0;
		int back_size = 0;

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);

			if (cmd == 'B') {
				if (!back.isEmpty()) {
					front.add(now);
					front_size += cap[now];
					back_size -= cap[back.peekLast()];
					now = back.pollLast();
				}
			} else if (cmd == 'F') {
				if (!front.isEmpty()) {
					back.add(now);
					back_size += cap[now];
					front_size -= cap[front.peekLast()];
					now = front.pollLast();
				}
			} else if (cmd == 'A') {
				int num = Integer.parseInt(st.nextToken());
				front_size = 0;
				front.clear();

				if (now != -1) {
					back.add(now);
					back_size += cap[now];
				}

				now = num;

				while (front_size + back_size + cap[now] > c) {
					back_size -= cap[back.pollFirst()];
				}
			} else if (cmd == 'C') {
				Deque<Integer> temp = new ArrayDeque<>();
				for (int x : back) {
					if (temp.isEmpty()) {
						temp.add(x);
					} else {
						if (temp.peekLast() != x) {
							temp.add(x);
						} else {
							back_size -= cap[x];
						}
					}
				}
				back = temp;
			}
		}

		sb.append(now).append("\n");

		if (back.isEmpty()) {
			sb.append(-1).append("\n");
		} else {
			Iterator<Integer> iter1 = back.descendingIterator();
			while (iter1.hasNext()) {
				sb.append(iter1.next()).append(" ");
			}
			sb.append("\n");
		}


		if (front.isEmpty()) {
			sb.append(-1).append("\n");
		} else {
			Iterator<Integer> iter2 = front.descendingIterator();
			while (iter2.hasNext()) {
				sb.append(iter2.next()).append(" ");
			}
		}

		System.out.println(sb);
	}
}

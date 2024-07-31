import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Deque<Integer> deque1 = new ArrayDeque<>();
		Deque<Integer> deque2 = new ArrayDeque<>();
		Deque<Integer> ground1 = new ArrayDeque<>();
		Deque<Integer> ground2 = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			deque1.addFirst(a);
			deque2.addFirst(b);
		}

		boolean doTurn = true;
		for (int i = 0; i < m; i++) {
			if (doTurn) {
				ground1.addFirst(deque1.pollFirst());
				if (deque1.isEmpty()) {
					System.out.println("su");
					return;
				}
			} else {
				ground2.addFirst(deque2.pollFirst());
				if (deque2.isEmpty()) {
					System.out.println("do");
					return;
				}
			}

			if (!ground1.isEmpty() && !ground2.isEmpty() && (ground1.peekFirst() + ground2.peekFirst() == 5)) {
				while (!ground1.isEmpty()) {
					deque2.addLast(ground1.pollLast());
				}
				while (!ground2.isEmpty()) {
					deque2.addLast(ground2.pollLast());
				}
			} else if ((!ground1.isEmpty() && ground1.peekFirst() == 5) || (!ground2.isEmpty() && ground2.peekFirst() == 5)) {
				while (!ground2.isEmpty()) {
					deque1.addLast(ground2.pollLast());
				}
				while (!ground1.isEmpty()) {
					deque1.addLast(ground1.pollLast());
				}
			}

			doTurn = !doTurn;
		}

		if (deque1.size() > deque2.size()) {
			System.out.println("do");
		} else if (deque1.size() < deque2.size()) {
			System.out.println("su");
		} else {
			System.out.println("dosu");
		}
	}
}
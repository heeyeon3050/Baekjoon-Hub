import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] cost = new int[n];
		int min = 50;
		int index = -1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());

			if (min >= cost[i]) { // 비용이 가장 작으면서 값이 큰 숫자 찾기
				min = cost[i];
				index = i;
			}
		}

		int money = Integer.parseInt(br.readLine());
		int[] num = new int[51];
		int cnt = 0;
		while (money >= min) { // 비용이 작은 숫자 배열에 넣기
			num[cnt++] = index;
			money -= min;
		}

		int start = 0; // digits 배열에서 우리가 구하려는 답의 자릿수가 시작하는 위치.
		for (int i = 0; i < cnt; i++) {
			for (int j = n - 1; j >= 0; j--) {
				// 현재 돈에다가 min을 더한 값이 statinonery[j]보다 크다는 뜻은
				// 더 큰 숫자를 살 수 있다는 의미이다.
				if (cost[j] <= money + min) {
					num[i] = j;
					money += min - cost[j];
					break;
				}
			}

			// digits[start]가 0이라는 뜻은
			// 현재 돈으로는 더 큰 숫자를 살 수 없다는 의미이다.
			// 따라서 자릿수를 1개 포기하고 min만큼의 돈을 다시 돌려 받는다.
			if (num[start] == 0) {
				start++;
				money += min;
			}
		}

		// start와 cnt가 같다는 뜻은
		// digits 배열에서 cnt까지의 인덱스 값이
		// 모두 0이라는 의미이고, 이것은 0~N-1까지의 수 중에서
		// 오직 0만 구입할 수 있다는 것을 의미한다.
		if (start == cnt) {
			System.out.println(0);
			return;
		}

		for (int i = start; i < cnt; i++) {
			sb.append(num[i]);
		}

		System.out.println(sb);
	}
}
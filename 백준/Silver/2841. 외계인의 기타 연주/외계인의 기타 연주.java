import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Stack<Integer>[] stack = new Stack[7]; //기타 6개의 줄 표현

		for(int i=1; i<=6; i++){
			stack[i] = new Stack<>();
		}

		int cnt = 0;
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(!stack[a].isEmpty()){
				if (stack[a].peek() >= b) {
					while (!stack[a].isEmpty() && stack[a].peek() > b) {
						stack[a].pop();
						cnt++;
					}
					if (!stack[a].isEmpty() && stack[a].peek() == b) {
						continue;
					}
				}
			}
			stack[a].push(b);
			cnt++;
		}

		System.out.println(cnt);
	}
}
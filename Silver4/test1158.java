package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test1158 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		int cnt = 1;
		
		while(queue.size() != 1) {
			while(cnt < K) {
				queue.offer(queue.poll());
				cnt++;
			}
			sb.append(queue.poll()).append(", ");
			cnt = 1;
			
		}
		
		sb.append(queue.poll() + ">");
		System.out.println(sb);
	}
}
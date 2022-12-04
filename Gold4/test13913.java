package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class test13913 {
	static int K;
	static int arr[] = new int[100001];
	static int parent[] = new int[100001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		bfs(N);
		sb.append(arr[K] + "\n");
		
		int num = K;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<=arr[K]; i++) {
			stack.add(num);
			num = parent[num];
		}
		
		for(int i=0; i<=arr[K]; i++) {
			sb.append(stack.pop() + " ");
		}
		
		System.out.println(sb);
	}
	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now == K)
				return;
			
			if(now-1>=0 && arr[now-1]==0) {
				arr[now-1] = arr[now] + 1;
				parent[now-1] = now;
				queue.add(now-1);
			}
			
			if(now+1<=100000 && arr[now+1]==0) {
				arr[now+1] = arr[now] + 1;
				parent[now+1] = now;
				queue.add(now+1);
			}
			
			if(now*2<=100000 && arr[now*2]==0) {
				arr[now*2] = arr[now] + 1;
				parent[now*2] = now;
				queue.add(now*2);
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] nums;
	static int[] person;
	static ArrayList<Integer>[] arr;
	static int limit = 0;
	static int total = 0;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		nums = new boolean[N+1];
		arr = new ArrayList[N+1];
		person = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			person[i] = Integer.parseInt(st.nextToken());
			total += person[i];
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<a; j++) {
				arr[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=1; i<=N/2; i++) {
			limit = i;
			combi(0, 1);
		}
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	
	static void combi(int depth, int start) {
		if(depth == limit) {
			if(bfs(true) && bfs(false)) {
				int cal = calculate();
				min = Math.min(min, cal);
			}
			return;
		}
		
		for(int i=start; i<=N; i++) {
			nums[i] = true;
			combi(depth+1, i+1);
			nums[i] = false;
		}
	}

	private static boolean bfs(boolean flag) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[N+1];
	
		for(int i=1; i<=N; i++) {
			if(nums[i] == flag) {
				queue.offer(i);
				visit[i] = true;
				break;
			}
		}
		
		int cnt = 1;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int a : arr[cur]) {
				if(!visit[a] && nums[a] == flag) {
					queue.offer(a);
					visit[a] = true; //큐에 중복으로 들어갈 수 있으므로 여기서 방문처리
					cnt++;
				}
			}
		}
		
		int size = flag ? limit : N-limit;
		
		if(cnt == size)
			return true;
		
		return false;
	}

	private static int calculate() {
		int sum = 0;
		for(int i=1; i<=N; i++) {
			if(nums[i]) {
				sum += person[i];
			}
		}
		return Math.abs(sum - (total-sum));
	}
}
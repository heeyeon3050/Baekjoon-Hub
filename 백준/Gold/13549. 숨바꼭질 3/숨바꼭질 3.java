import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Point{
		int x, time;

		public Point(int x, int time){
			this.x = x;
			this.time = time;
		}
	}

	static int n, k;
	static boolean[] visit = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		bfs(n);
	}

	public static void bfs(int x){
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(x, 0));
		visit[x] = true;

		while(!queue.isEmpty()){
			int size = queue.size();

			for(int i=0; i<size; i++){
				Point now = queue.poll();

				if(now.x == k){
					System.out.println(now.time);
					return;
				}

				if(2*now.x < 100001 && !visit[2*now.x]) {
					queue.add(new Point(2*now.x, now.time));
					visit[2*now.x] = true;
				}

				if(now.x-1 >= 0 && !visit[now.x-1]){
					queue.add(new Point(now.x-1, now.time+1));
					visit[now.x-1] = true;
				}

				if(now.x+1 < 100001 && !visit[now.x+1]) {
					queue.add(new Point(now.x+1, now.time+1));
					visit[now.x+1] = true;
				}
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Ball {
		int r, c, m, s, d;
		
		Ball(int r, int c, int m, int s, int d){
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int N;
	static ArrayList<Ball> list;
	static Ball[] ball;
	static Queue<Ball>[][] queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ball = new Ball[M];
		list = new ArrayList<>();
		queue = new Queue[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				queue[i][j] = new LinkedList<>();
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new Ball(r, c, m, s, d));
		}
		
		for(int i=0; i<K; i++) {
			move();
			combine();
		}
		
		int sum = 0;
		for(Ball b : list) {
			sum += b.m;
		}
		
		System.out.println(sum);
	}

	private static void move() {
		for(Ball b : list) {
			b.r = (b.r + dx[b.d] * b.s + N * b.s) % N;
			b.c = (b.c + dy[b.d] * b.s + N * b.s) % N;
			
			queue[b.r][b.c].offer(b);
		}
	}
	
	private static void combine() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(queue[i][j].size() >= 2) {
					int size = queue[i][j].size();
					int M = 0;
					int S = 0;
					boolean odd = true, even = true;
					while(!queue[i][j].isEmpty()) {
						Ball ball = queue[i][j].poll();
						M += ball.m;
						S += ball.s;
						
						if(ball.d % 2 == 0)
							odd = false;
						else
							even = false;
						
						list.remove(ball);
					}
					
					int nm = M/5;
					if(nm == 0) continue;
					int ns = S/size;
					
					if(odd != even) {
						for(int k=0; k<8; k+=2)
							list.add(new Ball(i, j, nm, ns, k));
					} else {
						for(int k=1; k<8; k+=2)
							list.add(new Ball(i, j, nm, ns, k));
					}
				} else
					queue[i][j].clear();
			}
		}
	}
}
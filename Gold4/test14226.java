package Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test14226 {
	static boolean visit[][] = new boolean[1001][1001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		
		bfs(S);
	}
	
	public static void bfs(int x) {
		Queue<emotion> queue = new LinkedList<>();
		queue.offer(new emotion(0, 1, 0));
		visit[0][0] = true;
		
		while(!queue.isEmpty()) {
			emotion now = queue.poll();
			if(now.screen == x) {
				System.out.println(now.time);
				return;
			}
			
			queue.offer(new emotion(now.screen, now.screen, now.time+1));
			
			if(now.clipboard!=0 && now.screen+now.clipboard<=x && !visit[now.clipboard][now.screen+now.clipboard]) {
				queue.offer(new emotion(now.clipboard, now.screen+now.clipboard, now.time+1));
				visit[now.clipboard][now.screen + now.clipboard] = true;
			}
			
			if(1<=now.screen && !visit[now.clipboard][now.screen-1]) {
				queue.offer(new emotion(now.clipboard, now.screen-1, now.time+1));
				visit[now.clipboard][now.screen-1] = true;
			}
		}
	}
}

class emotion{
	int clipboard = 0;
	int screen = 0;
	int time = 0;
	
	emotion(int clipboard, int screen, int time){
		this.clipboard = clipboard;
		this.screen = screen;
		this.time = time;
	}
}

package Silver4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test16173 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int field[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Reach> reachQueue = new LinkedList<>();
		boolean visited[][] = new boolean[N][N];
		
		reachQueue.add(new Reach(0, 0));
		boolean canFinish = false;
		
		while(!reachQueue.isEmpty()) {
			Reach reachTemp = reachQueue.poll();
			if(visited[reachTemp.cols][reachTemp.rows])
				continue;
			int jumpPower = field[reachTemp.cols][reachTemp.rows];
			if (jumpPower == -1) {
				canFinish = true;
				break;
			}
			visited[reachTemp.cols][reachTemp.rows] = true;
			if (reachTemp.cols + jumpPower < N)
				reachQueue.add(new Reach(reachTemp.cols + jumpPower, reachTemp.rows));
			if (reachTemp.rows + jumpPower < N)
				reachQueue.add(new Reach(reachTemp.cols, reachTemp.rows + jumpPower));
		}
		
		if (canFinish)
			sb.append("HaruHaru\n");
		else
			sb.append("Hing\n");
		
		//System.out.println(sb);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
		
	static class Reach{
		int cols;
		int rows;
		
		public Reach(int cols, int rows) {
			this.cols = cols;
			this.rows = rows;
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Reach> queue = new LinkedList<>();
		boolean visit[][] = new boolean[N][N];
		boolean canFinish = false;
		queue.offer(new Reach(0, 0));
		while(!queue.isEmpty()) {
			Reach temp = queue.poll();
			visit[temp.cols][temp.rows] = true;
			int jumpPower = arr[temp.cols][temp.rows];
			if(arr[temp.cols][temp.rows] == -1) {
				canFinish = true;
				break;
			}
			if(temp.cols + jumpPower < N && !visit[temp.cols + jumpPower][temp.rows])
				queue.offer(new Reach(temp.cols + jumpPower, temp.rows));
			if(temp.rows + jumpPower < N && !visit[temp.cols][temp.rows + jumpPower])
				queue.offer(new Reach(temp.cols, temp.rows + jumpPower));
		}
		
		if(canFinish)
			System.out.println("HaruHaru");
		else
			System.out.println("Hing");
	}
	
	static public class Reach{
		int cols;
		int rows;
		
		Reach(int cols, int rows){
			this.cols = cols;
			this.rows = rows;
		}
	}
}
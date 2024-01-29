import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int arr[][];
	static boolean visit[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][8];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++)
				arr[i][j] = str.charAt(j) - '0';
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			visit = new boolean[N];
			compute(num-1, dir);
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(arr[i][0] == 1)
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static void compute(int x, int d) {
		visit[x] = true;
		rotate(x, d);
		
		if(x-1>=0 && !visit[x-1] && arr[x-1][2] != arr[x][6+d])
			compute(x-1, d*-1);
		if(x+1<N && !visit[x+1] && arr[x+1][6] != arr[x][2+d])
			compute(x+1, d*-1);
	}
	
	public static void rotate(int x, int d) {
		if(d == 1) {
			int temp = arr[x][7];
			for(int i=7; i>0; i--) {
				arr[x][i] = arr[x][i-1];
			}
			arr[x][0] = temp;
		}
		
		else {
			int temp = arr[x][0];
			for(int i=0; i<7; i++) {
				arr[x][i] = arr[x][i+1];
			}
			arr[x][7] = temp;
		}
	}
}
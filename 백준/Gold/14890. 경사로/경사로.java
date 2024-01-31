import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int map[][];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(check(i, 0, 0))
				cnt++;
			
			if(check(0, i, 1))
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static boolean check(int x, int y, int d) {
		int height[] = new int[N];
		boolean visit[] = new boolean[N];
		
		for(int i=0; i<N; i++) {
			height[i] = (d==0) ? map[x][y+i] : map[x+i][y];
		}
		
		
		for(int i=0; i<N-1; i++	) {
			//높이가 같으면 패스
			if(height[i] == height[i+1])
				continue;
			
			//높이가 2이상
			if(Math.abs(height[i] - height[i+1]) > 1)
				return false;
			
			//내려가야되는 경우
			if(height[i] > height[i+1]) { 
				for(int j=i+1; j<=i+L; j++	) {
					if(j>=N || height[i+1] != height[j] || visit[j])
						return false;
					visit[j] = true;
				}
			}
			
			//올라가야되는 경우
			if(height[i] < height[i+1]) { 
				for(int j=i; j>i-L; j--	) {
					if(j<0 || height[i] != height[j] || visit[j])
						return false;
					visit[j] = true;
				}
			}
		}
		return true;
	}
}
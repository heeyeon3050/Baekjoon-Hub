import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int n, m, k;
	public static int[] num;
	public static int[][] arr;
	public static boolean[][] visit;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recur(0, 0, 0, 0);

		System.out.println(max);
	}

	public static void recur(int cnt, int x, int y, int sum){
		if(cnt == k){
			max = Math.max(max, sum);
			return;
		}

		for(int i=x; i<n; i++){
			for(int j = (i == x ? y : 0); j < m; j++){
				if(visit[i][j])
					continue;
				if(check(i, j)){ //인접한 값이 없을 경우
					visit[i][j] = true;
					recur(cnt+1, i, j+1, sum+arr[i][j]);
					visit[i][j] = false;
				}
			}
		}
	}

	public static boolean check(int x, int y){
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if(visit[nx][ny])
				return false;
		}
		return true;
	}
}
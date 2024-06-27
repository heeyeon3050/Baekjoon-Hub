import java.util.*;
import java.io.*;

public class Main {
	static int r, c, k;
	static String[][] arr;
	static int answer = 0;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new String[r][c];
		visit = new boolean[r][c];

		for(int i=0; i<r; i++){
			arr[i] = br.readLine().split("");
		}

		dfs(r-1, 0, 1);
		System.out.println(answer);
	}

	public static void dfs(int x, int y, int cnt){
		if(x < 0 || x >= r || y < 0 || y >= c || visit[x][y] || arr[x][y].equals("T")){
			return;
		}

		if(x == 0 && y == c-1){
			if(cnt == k)
				answer++;
			return;
		}

		visit[x][y] = true;

		dfs(x+1, y, cnt+1);
		dfs(x-1, y, cnt+1);
		dfs(x, y+1, cnt+1);
		dfs(x, y-1, cnt+1);

		visit[x][y] = false;
	}
}
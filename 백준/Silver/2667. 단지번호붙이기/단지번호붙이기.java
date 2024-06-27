import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int n;
	static int[][] arr;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		visit = new boolean[n][n];

		for(int i=0; i<n; i++){
			String str = br.readLine();
			int size = str.length();
			for(int j=0; j<size; j++){
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(arr[i][j] == 1){
					arr[i][j] = 0;
					list.add(bfs(i, j));
				}
			}
		}
		sb.append(list.size()).append("\n");

		Collections.sort(list);
		for(int l : list){
			sb.append(l).append("\n");
		}

		System.out.println(sb);
	}

	public static int bfs(int x, int y){
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{x, y});

		int cnt = 1;
		while(!queue.isEmpty()){
			int size = queue.size();

			for(int i=0; i<size; i++){
				int[] now = queue.poll();

				for(int j=0; j<4; j++){
					int nx = now[0] + dx[j];
					int ny = now[1] + dy[j];

					if(nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;

					if(arr[nx][ny] == 1) {
						arr[nx][ny] = 0;
						queue.add(new int[]{nx, ny});
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
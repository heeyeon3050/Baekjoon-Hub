import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int R, C;
	static int cleanerX;
	static int[][] arr, temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		temp = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == -1) {
					arr[i][j] = 0;
					cleanerX = i;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			spread();
			run();
		}

		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum += arr[i][j];
			}
		}

		System.out.println(sum);
	}

	private static void spread() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j] == 0) continue;
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;
					if (nx == cleanerX && ny == 0)
						continue;
					if (nx == cleanerX - 1 && ny == 0)
						continue;

					temp[nx][ny] += arr[i][j] / 5;
					cnt++;
				}
				temp[i][j] += arr[i][j] - ((arr[i][j] / 5) * cnt);
			}
		}

		arr = temp;
		temp = new int[R][C];
	}

	private static void run() {
		int x1 = cleanerX - 1;
		int x2 = cleanerX;

		for (int i = x1 - 1; i >= 1; i--) {
			arr[i][0] = arr[i - 1][0];
		}

		arr[x1][0] = 0;

		for (int i = 0; i < C - 1; i++) {
			arr[0][i] = arr[0][i + 1];
		}

		for (int i = 0; i < x1; i++) {
			arr[i][C - 1] = arr[i + 1][C - 1];
		}

		for (int i = C - 1; i >= 1; i--) {
			arr[x1][i] = arr[x1][i - 1];
		}

//-------------------

		for (int i = x2; i < R - 1; i++) {
			arr[i][0] = arr[i + 1][0];
		}

		arr[x2][0] = 0;

		for (int i = 0; i < C - 1; i++) {
			arr[R - 1][i] = arr[R - 1][i + 1];
		}

		for (int i = R - 1; i >= x2+1; i--) {
			arr[i][C - 1] = arr[i - 1][C - 1];
		}

		for (int i = C - 1; i >= 1; i--) {
			arr[x2][i] = arr[x2][i - 1];
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {

	static class State {
		char[][] grid;
		int moves;

		public State(char[][] grid, int moves) {
			this.grid = grid;
			this.moves = moves;
		}

		// 현재 상태가 목표 상태와 일치하는지 확인
		public boolean isGoal(char[][] target) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (this.grid[i][j] != target[i][j]) {
						return false;
					}
				}
			}
			return true;
		}

		// 현재 상태를 복사하여 새로운 상태로 만듦
		public char[][] copyGrid() {
			char[][] newGrid = new char[4][4];
			for (int i = 0; i < 4; i++) {
				System.arraycopy(this.grid[i], 0, newGrid[i], 0, 4);
			}
			return newGrid;
		}

		// 상태의 배열을 문자열로 변환하여 Set에 저장하고 비교할 수 있게 함
		public String gridToString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 4; i++) {
				sb.append(this.grid[i]);
			}
			return sb.toString();
		}

		// 인접한 상태를 모두 반환
		public List<State> getNextStates() {
			List<State> nextStates = new ArrayList<>();
			int[] dx = {1, -1, 0, 0}; // 상하좌우 이동
			int[] dy = {0, 0, 1, -1};

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
							char[][] newGrid = copyGrid();
							// 인접한 위치끼리 교체
							char temp = newGrid[i][j];
							newGrid[i][j] = newGrid[nx][ny];
							newGrid[nx][ny] = temp;
							nextStates.add(new State(newGrid, this.moves + 1));
						}
					}
				}
			}
			return nextStates;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] startGrid = new char[4][4];
		char[][] targetGrid = new char[4][4];

		// 현재 상태 입력
		for (int i = 0; i < 4; i++) {
			startGrid[i] = br.readLine().toCharArray();
		}

		// 빈 줄 무시
		String str = br.readLine();
		while (str.isEmpty())
			str = br.readLine();

		targetGrid[0] = str.toCharArray();
		// 목표 상태 입력
		for (int i = 1; i < 4; i++) {
			targetGrid[i] = br.readLine().toCharArray();
		}

		// BFS 탐색으로 최소 교체 횟수 구하기
		int result = bfs(startGrid, targetGrid);
		System.out.println(result);
	}

	// BFS를 사용하여 최소 자리 바꿈 횟수 구하기
	public static int bfs(char[][] startGrid, char[][] targetGrid) {
		Queue<State> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		State startState = new State(startGrid, 0);
		queue.add(startState);
		visited.add(startState.gridToString());

		while (!queue.isEmpty()) {
			State current = queue.poll();

			// 목표 상태에 도달하면 교체 횟수를 반환
			if (current.isGoal(targetGrid)) {
				return current.moves;
			}

			// 다음 상태로 이동
			for (State nextState : current.getNextStates()) {
				String gridString = nextState.gridToString();
				if (!visited.contains(gridString)) {
					visited.add(gridString);
					queue.add(nextState);
				}
			}
		}

		return -1; // 불가능한 경우가 없으므로 이 부분은 도달하지 않음
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parent = new int[n+1];
		for(int i=0; i<=n; i++){
			parent[i] = i;
		}

		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++){
				int num = Integer.parseInt(st.nextToken());
				if(num == 1){
					union(i, j);
				}
			}
		}

		String answer = "YES";
		st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		for(int i=0; i<m-1; i++){
			int next = Integer.parseInt(st.nextToken());
			if(start != find(next)){
				answer = "NO";
				break;
			}
		}

		System.out.println(answer);
	}

	public static void union(int x, int y){
		int rootX = find(x);
		int rootY = find(y);

		if(rootX < rootY){
			parent[rootY] = rootX;
		} else{
			parent[rootX] = rootY;
		}
	}

	public static int find(int x){
		if(parent[x] != x)
			parent[x] = find(parent[x]);
		return parent[x];
	}
}
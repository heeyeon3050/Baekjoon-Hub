import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int[] arr;
	static boolean[] visit;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		visit = new boolean[n+1];

		for(int i=1; i<=n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i=1; i<=n; i++){
			visit[i] = true;
			dfs(i, i);
			visit[i] = false;
		}

		Collections.sort(list);
		System.out.println(list.size());
		for(int x: list){
			System.out.println(x);
		}
	}

	public static void dfs(int start, int target){
		if(arr[start] == target)
			list.add(target);

		if(!visit[arr[start]]){
			visit[arr[start]] = true;
			dfs(arr[start], target);
			visit[arr[start]] = false;
		}
	}
}
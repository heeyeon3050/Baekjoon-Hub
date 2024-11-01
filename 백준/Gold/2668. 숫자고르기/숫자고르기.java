import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static boolean[] visit;
	static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		visit = new boolean[n+1];
		list = new ArrayList<>();

		for(int i=1; i<=n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		for(int i=1; i<=n; i++){
			visit[i] = true;
			dfs(i, i);
			visit[i] = false;
		}

		sb.append(list.size()).append("\n");
		Collections.sort(list);
		for(int i : list){
			sb.append(i).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int start, int target){
		if(!visit[arr[start]]){
			visit[arr[start]] = true;
			dfs(arr[start], target);
			visit[arr[start]] = false;
		}
		if(arr[start] == target)
			list.add(target);
	}
}
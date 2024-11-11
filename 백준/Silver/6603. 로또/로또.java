import java.io.*;
import java.util.*;

public class Main {
	static int k;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		while(true){
			String str = br.readLine();
			if(str.equals("0"))
				break;

			StringTokenizer st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			visit = new boolean[k];
			for(int i=0; i<k; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0, new int[6]);

			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int depth, int start, int[] num){
		if(depth == 6){
			for(int i : num){
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=start; i<k; i++){
			if(!visit[i]){
				visit[i] = true;
				num[depth] = arr[i];
				dfs(depth+1, i+1, num);
				visit[i] = false;
			}
		}
	}
}

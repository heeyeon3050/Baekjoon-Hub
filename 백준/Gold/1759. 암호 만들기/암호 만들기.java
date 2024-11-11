import java.io.*;
import java.util.*;

public class Main {
	static int l, c;
	static char[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new char[c];
		for(int i=0; i<c; i++){
			arr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(arr);
		dfs(0, 0, new char[l]);

		System.out.println(sb);
	}

	public static void dfs(int depth, int start, char[] result){
		if(depth == l){
			if(check(result)) {
				for (char i : result) {
					sb.append(i);
				}
				sb.append("\n");
			}
			return;
		}

		for(int i=start; i<c; i++){
			result[depth] = arr[i];
			dfs(depth+1, i+1, result);
		}
	}

	public static boolean check(char[] arr){
		int cnt = 0;
		for(int i=0; i<l; i++){
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u')
				cnt++;
		}

		if(cnt >= 1 && (l-cnt) >= 2)
			return true;
		else
			return false;
	}
}
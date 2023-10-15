import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int num[];
	static boolean visit[];
	static int arr[];
	static int k;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) {
				break;
			}
			
			arr = new int[k];
			num = new int[6];
			visit = new boolean[k+1];
			
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	/*
	static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int val : num) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                num[depth] = arr[i];
                dfs(i, depth + 1);
                visit[i] = false;
            }
        }
    }
    */
	
	
	
	public static void dfs(int x, int cnt) {
		if(cnt == 6) {
			for(int i=0; i<k; i++) {
				if(visit[i])
					sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=x; i<k; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i+1, cnt+1);
				visit[i] = false;
			}
			
		}
	}
}
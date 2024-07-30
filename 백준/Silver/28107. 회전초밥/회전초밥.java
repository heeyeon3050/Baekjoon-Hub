import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Queue<Integer>[] queue = new Queue[200001];
		for(int i=0; i<=200000; i++){
			queue[i] = new ArrayDeque<>();
		}

		//초밥의 종류에 사람의 번호를 넣기
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j=0; j<k; j++){
				int num = Integer.parseInt(st.nextToken());
				queue[num].add(i);
			}
		}

		int[] cnt = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++){
			int sushi = Integer.parseInt(st.nextToken());
			if(!queue[sushi].isEmpty()){
				cnt[queue[sushi].poll()]++;
			}
		}

		for(int i=0; i<n; i++){
			sb.append(cnt[i]).append(" ");
		}

		System.out.println(sb);
	}
}
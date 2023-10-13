import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] arr = new String[N];
		String[] check = new String[M];

		for(int i=0; i<N; i++){
			arr[i] = br.readLine();
		}

		for(int i=0; i<M; i++){
			check[i] = br.readLine();
		}

		int cnt = 0;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(arr[i].equals(check[j]))
					cnt++;
			}
		}

		System.out.println(cnt);
	}
}

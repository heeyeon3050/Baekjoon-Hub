import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			change(a, b);
		}
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i]);
			if((i+1) % 20 == 0) {
				sb.append("\n");
			} else {
				sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}
	
	public static void change(int a, int b) {
		if(a == 1) {
			for(int i=0; i<N; i++) {
				if((i+1) % b == 0) {
					arr[i] = arr[i] == 0 ? 1 : 0;
				}
			}
		}
		
		else {
			arr[b - 1] = arr[b - 1] == 0 ? 1 : 0;
			for(int i=1; i<=N/2; i++) {
				if(b-1-i >= 0 && b-1+i < N) {
					if(arr[b-1-i] == arr[b-1+i]) {
						arr[b - 1 - i] = arr[b - 1 - i] == 0 ? 1 : 0;
						arr[b - 1 + i] = arr[b - 1 + i] == 0 ? 1 : 0;
					} else 
						break;
				} else
					break;
			}
		}
	}
}
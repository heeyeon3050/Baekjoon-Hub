import java.io.*;
import java.util.*;

public class Main {
	static final int INF = 1000000;
	static boolean[] prime = new boolean[INF+1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Arrays.fill(prime, true);
		isPrime();

		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++){
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			for(int i=2; i<=n/2; i++){
				if(prime[i] && prime[n-i])
					cnt++;
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}

	public static void isPrime(){
		prime[0] = false;
		prime[1] = false;

		for(int i=2; i*i<=INF; i++){
			if(prime[i]){
				for(int j=i*i; j<=INF; j+=i){
					prime[j] = false;
				}
			}
		}
	}
}
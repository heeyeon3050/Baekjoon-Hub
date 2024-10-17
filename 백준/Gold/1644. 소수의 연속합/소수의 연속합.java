import java.io.*;
import java.util.*;

public class Main {
	static boolean[] prime;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		prime = new boolean[n+1];
		isPrime(n);

		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		while(start <= end && end < list.size()){
			if(sum < n){
				sum += list.get(end++);
			} else {
				if(sum == n)
					cnt++;
				sum -= list.get(start++);
			}
		}

		System.out.println(cnt);
	}

	public static void isPrime(int n){
		Arrays.fill(prime , true);
		prime[0] = false;
		prime[1] = false;

		for(int i=2; i*i<=n; i++){
			if(prime[i]) {
				for (int j = i*i; j <= n; j += i) {
					prime[j] = false;
				}
			}
		}

		for(int i=1; i<=n; i++){
			if(prime[i])
				list.add(i);
		}
		list.add(0); // 투포인터 탐색할 때 end 마지막 값까지 탐색하기 위해 임의로 넣음
	}
}
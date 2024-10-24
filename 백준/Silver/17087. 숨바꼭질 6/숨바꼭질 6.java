import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int[] dis = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
			dis[i] = Math.abs(s - arr[i]);
		}

		int gcd = dis[0];
		for(int i=0; i<n; i++){
			gcd = gcd(gcd, dis[i]);
		}

		System.out.println(gcd);
	}

	public static int gcd(int a, int b){
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
}
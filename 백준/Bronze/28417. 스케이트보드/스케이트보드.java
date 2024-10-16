import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int max = 0;
		for(int i=0; i<n; i++){
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sum = Math.max(a, b);

			int[] trick = new int[5];
			for(int j=0; j<5; j++){
				trick[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(trick);

			sum += (trick[3] + trick[4]);

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}
}
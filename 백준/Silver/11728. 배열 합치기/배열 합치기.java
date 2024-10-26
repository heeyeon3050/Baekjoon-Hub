import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] a = new int[n];
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++){
			b[i] = Integer.parseInt(st.nextToken());
		}

		int p1 = 0;
		int p2 = 0;
		while(p1 < n && p2 < m){
			if(a[p1] < b[p2]){
				sb.append(a[p1++]).append(" ");
			} else {
				sb.append(b[p2++]).append(" ");
			}
		}

		while(p1 < n){
			sb.append(a[p1++]).append(" ");
		}

		while(p2 < m){
			sb.append(b[p2++]).append(" ");
		}

		System.out.println(sb);
	}
}
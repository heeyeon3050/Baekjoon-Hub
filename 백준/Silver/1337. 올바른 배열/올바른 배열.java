import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int answer = 0;
		for(int i=0; i<n; i++){
			int cnt = 1;
			int max = arr[i] + 4;

			for(int j=i+1; j<i+5; j++){
				if(j >= n)
					break;
				if(arr[j] <= max)
					cnt++;
			}

			answer = Math.max(answer, cnt);
		}

		System.out.println(5-answer);
	}
}
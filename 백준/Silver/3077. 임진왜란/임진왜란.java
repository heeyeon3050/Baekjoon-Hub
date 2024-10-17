import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			map.put(st.nextToken(), i);
		}

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = map.get(st.nextToken());
		}

		int total = 0;
		for(int i=0; i<n-1; i++){
			for(int j=i+1; j<n; j++){
				if(arr[i] < arr[j])
					total++;
			}
		}

		System.out.println(total + "/" + n*(n-1)/2);
	}
}
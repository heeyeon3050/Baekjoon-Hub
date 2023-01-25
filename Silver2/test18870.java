package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class test18870 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int num[] = new int[N];
		Map<Integer, Integer> hashmap = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		num = arr.clone();
		Arrays.sort(num);
		int number = 0;
		for(int i=0; i<N; i++) {
			if(!hashmap.containsKey(num[i]))
				hashmap.put(num[i], number++);
		}
		
		for(int i=0; i<N; i++) {
			sb.append(hashmap.get(arr[i]) + " ");
		}
		
		System.out.println(sb);
	}
}
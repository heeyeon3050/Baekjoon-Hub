package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class test2108 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		double sum = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		sb.append(Math.round(sum/N)).append('\n');
		
		Arrays.sort(arr);
		sb.append(arr[N/2]).append('\n');
		
		List <Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			hashmap.put(arr[i], hashmap.getOrDefault(arr[i], 0)+1);
		}
		
		int max = 0;
		for(int key : hashmap.values())
			max = Math.max(max, key);
		
		for(int key : hashmap.keySet()) {
			if(hashmap.get(key) == max)
				list.add(key);
		}
		
		Collections.sort(list);
		
		if(list.size() <= 1)
			sb.append(list.get(0)).append('\n');
		else
			sb.append(list.get(1)).append('\n');
		
		sb.append(arr[N-1]-arr[0]);
		
		System.out.println(sb);
	}
}

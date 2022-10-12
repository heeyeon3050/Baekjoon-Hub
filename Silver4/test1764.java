package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class test1764 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> set = new HashSet<>();
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		for(int i=0; i<M; i++) {
			String tmp = br.readLine();
			if(set.contains(tmp)) {
				list.add(tmp);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
}

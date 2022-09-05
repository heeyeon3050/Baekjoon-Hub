package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class test1015_1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		ArrayList<Pair> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(new Pair(i, Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.value < o2.value) {
					return -1;
				}
				else if(o1.value > o2.value) {
					return 1;
				}
				else {
					if(o1.idx < o2.idx) {
						return -1;
					}
					else
						return 1;
				}
			}
		});
		
		int p[] = new int[1001];
		for(int i=0; i<N; i++) {
			p[list.get(i).idx] = i;
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(p[i] + " ");
		}
	}
	
	public static class Pair{
		int idx;
		int value;
		
		Pair(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	}
}

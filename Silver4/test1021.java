package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class test1021 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			deque.add(i+1);
		}
		
		for(int i=0; i<M; i++) {
			int x = deque.pollFirst();
			if(x==2)
		}
	}
}

package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test13305 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int dis[] = new int[N-1];
		int cost[] = new int[N-1];
		long sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
				dis[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long minCost = cost[0];
		for(int i=0; i<N-1; i++) {
			if(cost[i]<minCost) {
				minCost = cost[i];
			}
			sum += dis[i]*minCost;
		}
		
		System.out.println(sum);
	}
}

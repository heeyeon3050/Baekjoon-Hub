package Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class test1417 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    
		
		int N = Integer.parseInt(br.readLine());
		int dasom = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<N-1; i++) {
			priorityQueue.add(Integer.parseInt(br.readLine()));
		}
		
		int answer = 0;
		if(N != 1) {
			while(priorityQueue.peek() >= dasom) {
				answer++;
				dasom++;
				int temp = priorityQueue.poll();
				priorityQueue.add(temp-1);
			}
		}
		
		System.out.println(answer);
	}
}

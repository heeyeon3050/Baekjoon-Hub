package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test10845 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Queue<String> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		String num = "";
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			String arr[] = str.split(" ");
			if(arr.length>1)
				num = arr[1];
			
			switch(arr[0]) {
				case "push" :
					queue.add(arr[1]);
					break;
				case "pop" :
					if(queue.isEmpty()) {
						sb.append(-1).append('\n');
						break;
					}
					else {
						sb.append(queue.poll()).append('\n');
						break;
					}
				case "size" :
					sb.append(queue.size()).append('\n');
					break;
				case "empty" :
					if(queue.isEmpty())
						sb.append(1).append('\n');
					else
						sb.append(0).append('\n');
					break;
				case "front" :
					if(queue.isEmpty()) {
						sb.append(-1).append('\n');
						break;
					}
					else {
						sb.append(queue.peek()).append('\n');
						break;
					}
				case "back" : 
					if(queue.isEmpty()) {
						sb.append(-1).append('\n');
						break;
					}
					else {
						sb.append(num).append('\n');
						break;
					}
			}
		}
		System.out.println(sb);
	}
}

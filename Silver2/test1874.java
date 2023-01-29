package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test1874 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int j=1;
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			while(j <= num) {
				stack.add(j++);
				sb.append('+').append('\n');
			}
			
			if(num == stack.peek()) {
				stack.pop();
				sb.append('-').append('\n');
			}
			
			else {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println(sb);
	}
}

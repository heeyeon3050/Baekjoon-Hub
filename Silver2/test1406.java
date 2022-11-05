package Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test1406 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> left_stack = new Stack<>();
		Stack<Character> right_stack = new Stack<>();
		
		String str = br.readLine();
		char arr[] = str.toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			left_stack.push(arr[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			str = br.readLine();
			arr = str.toCharArray();
			
			switch(arr[0]){
				case 'L' :
					if(left_stack.empty())
						break;
					right_stack.push(left_stack.pop());
					break;
				case 'D' :
					if(right_stack.empty())
						break;
					left_stack.push(right_stack.pop());
					break;
				case 'B' :
					if(left_stack.empty())
						break;
					left_stack.pop();
					break;
				case 'P' :
					left_stack.push(arr[2]);
			}
		}
		while(!left_stack.empty())
			right_stack.push(left_stack.pop());
		
		while(!right_stack.empty())
			sb.append(right_stack.pop());
		
		System.out.println(sb);
	}
}

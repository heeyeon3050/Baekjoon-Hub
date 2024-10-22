import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine() + " ";

		int length = str.length();
		boolean flag = false;
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new ArrayDeque<>();
		for(int i=0; i<length; i++){
			char x = str.charAt(i);
			if(flag && x == '>'){
				queue.add(x);
				while(!queue.isEmpty()){
					sb.append(queue.poll());
				}
				flag = false;
				queue = new ArrayDeque<>();
			} else if(flag && (x >= 'a' && x <= 'z' || x == ' ')){
				queue.add(x);
			} else if(!flag && ((x >= 'a' && x <= 'z') || (x >= '0' && x<= '9'))){
				stack.push(x);
			} else if(x == '<') {
				flag = true;
				queue.add(x);
				while(!stack.isEmpty()){
					sb.append(stack.pop());
				}
				stack = new Stack<>();
			} else if(!flag && x == ' '){

				while(!stack.isEmpty()){
					sb.append(stack.pop());
				}
				sb.append(" ");
				stack = new Stack<>();
			}
		}

		System.out.println(sb);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		Stack<Character> stack = new Stack<>();

		int length = str.length();
		for(int i=0; i<length; i++){
			char x = str.charAt(i);
			if(x >= 'A' && x<= 'Z')
				sb.append(x);
			else if(x == '(')
				stack.push(x);
			else if(x == ')'){
				while(!stack.isEmpty() && stack.peek() != '(')
					sb.append(stack.pop());
				stack.pop();
			} else {
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(x)){
						sb.append(stack.pop());
				}
				stack.push(x);
			}
		}

		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}

		System.out.println(sb);
	}

	public static int priority(char x){
		if(x == '(' || x == ')')
			return 0;
		if(x == '+' || x == '-')
			return 1;
		else
			return 2;
	}
}
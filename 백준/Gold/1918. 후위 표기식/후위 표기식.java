import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			switch(str.charAt(i)) {
				case '+' :
				case '-' :
				case '*' :
				case '/' :
					while(!stack.empty() && priority(stack.peek()) >= priority(str.charAt(i))) {
						sb.append(stack.pop());
					}
					stack.add(str.charAt(i));
					break;
				case '(' :
					stack.add(str.charAt(i));
					break;
				case ')' :
					while(!stack.empty() && stack.peek()!='(') {
						sb.append(stack.pop());
					}
					stack.pop();
					break;
				default :
					sb.append(str.charAt(i));
			}
		}
		
		while(!stack.empty())
			sb.append(stack.pop());
		
		System.out.println(sb);
	}
	
	public static int priority(char operator) {
		if(operator=='(' || operator==')')
			return 0;
		else if(operator=='+' || operator=='-')
			return 1;
		else if(operator=='*' || operator=='/')
			return 2;
		else
			return -1;
	}
}
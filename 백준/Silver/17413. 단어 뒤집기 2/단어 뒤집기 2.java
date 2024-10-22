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
		for(int i=0; i<length; i++){
			char x = str.charAt(i);

			if(x == '<'){
				flag = true;
				while(!stack.isEmpty()){
					sb.append(stack.pop());
				}
			} else if(x == '>'){
				flag = false;
				sb.append(x);
				continue;
			}

			if(flag)
				sb.append(x);
			else {
				if(x == ' ') {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(" ");
				} else {
					stack.push(x);
				}
			}
		}

		System.out.println(sb);
	}
}
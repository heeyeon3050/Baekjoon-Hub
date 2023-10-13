import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack <Character> stack = new Stack<>();
		String str = br.readLine();
		
		boolean check = false;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='<') {
				check = true;
				while(!stack.empty()) {
					sb.append(stack.pop());
				}
				sb.append(str.charAt(i));
			}
			else if(str.charAt(i)=='>') {
				check = false;
				sb.append(str.charAt(i));
			}
			else if(check){
				sb.append(str.charAt(i));
			}
			else {
				if(str.charAt(i)==' ') {
					while(!stack.empty())
						sb.append(stack.pop());
					sb.append(' ');
				}
				else
					stack.add(str.charAt(i));
			}
		}
		while(!stack.empty())
			sb.append(stack.pop());
		System.out.println(sb);
	}
}
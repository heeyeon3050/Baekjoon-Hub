package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class test1935 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		Stack<Double> stack = new Stack<>();
		HashMap<Character, Double> map = new HashMap<>();
		char alpha = 'A';
		for(int i=0; i<N; i++) {
			map.put(alpha++, Double.parseDouble(br.readLine()));
		}
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) >= 48) {
				stack.add(map.get(str.charAt(i)));
				
			}
			else {
				double a = stack.pop();
				double b = stack.pop();
				switch(str.charAt(i)) {
					case '+':
						stack.add(b+a);
						break;
					case '-':
						stack.add(b-a);
						break;
					case '*':
						stack.add(b*a);
						break;
					case '/':
						stack.add(b/a);
						break;
				}
			}
		}
		System.out.println(String.format("%.2f", stack.pop()));
	}
}

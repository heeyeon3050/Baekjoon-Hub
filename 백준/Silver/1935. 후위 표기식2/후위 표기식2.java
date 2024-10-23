import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();

		Map<Character, Double> map = new HashMap<>();
		for(int i=0; i<n; i++){
			double num = Integer.parseInt(br.readLine());
			map.put((char)('A'+i), num);
		}

		Stack<Double> stack = new Stack<>();

		int length = str.length();
		for(int i=0; i<length; i++){
			char x = str.charAt(i);
			if(x >= 'A' && x <= 'Z'){
				stack.add(map.get(x));
			} else {
				double a = stack.pop();
				double b = stack.pop();
				switch (x){
					case '+':
						stack.push(b+a);
						break;
					case '-':
						stack.push(b-a);
						break;
					case '*':
						stack.push(b*a);
						break;
					case '/':
						stack.push(b/a);
						break;
				}
			}
		}

		System.out.println(String.format("%.2f", stack.pop()));
	}
}
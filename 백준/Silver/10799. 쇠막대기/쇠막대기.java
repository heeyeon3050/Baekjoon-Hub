import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		Stack<Character> stack = new Stack<>();

		int sum = 0;
		char prev = '(';
		int length = str.length();
		for(int i=0; i<length; i++){
			char x = str.charAt(i);
			if(x == '(')
				stack.push(x);
			else{
				stack.pop();
				if(prev != x)
					sum += stack.size();
				else
					sum++;
			}
			prev = x;
		}

		System.out.println(sum);
	}
}
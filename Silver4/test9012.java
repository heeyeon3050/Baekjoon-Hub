package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class test9012 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>();
		
		for(int i=0; i<T; i++) {
			stack.clear();
			String str = br.readLine();
			String arr[] = str.split("");
			
			for(int j=0; j<arr.length; j++) {
				if(arr[j].equals("("))
					stack.add(arr[j]);
				else {
					if(stack.empty()) {
						stack.add(arr[j]);
						break;
					}
					else {
						stack.pop();
					}
				}
			}
			if(stack.empty())
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		
		System.out.println(sb);
	}
}

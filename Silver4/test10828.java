package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class test10828 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<>();
		String arr[] = new String[2];
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr = br.readLine().split(" ");
			switch(arr[0]){
				
				case "push" :
					stack.add(arr[1]);
					break;
				case "pop" :
					if(stack.empty())
						sb.append(-1).append("\n");
					else
						sb.append(stack.pop()).append("\n");
					break;
				case "size" :
					sb.append(stack.size()).append("\n");
					break;
				case "empty" :
					if(stack.empty())
						sb.append(1).append("\n");
					else
						sb.append(0).append("\n");
					break;
				case "top" :
					if(stack.empty())
						sb.append(-1).append("\n");
					else
						sb.append(stack.peek()).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
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
						sb.append("NO").append("\n");
						break;
					}
					else {
						stack.pop();
					}
				}
				
				if(j==arr.length-1) {
					if(stack.empty())
						sb.append("YES").append("\n");
					else
						sb.append("NO").append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
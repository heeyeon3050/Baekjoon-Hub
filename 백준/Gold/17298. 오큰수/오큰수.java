import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] nge = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<n; i++){
			while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
				nge[stack.pop()] = arr[i];
			}
			stack.push(i);
		}

		for(int i=0; i<n; i++){
			if(nge[i] == 0)
				sb.append(-1);
			else
				sb.append(nge[i]);
			sb.append(" ");
		}

		System.out.println(sb);
	}
}
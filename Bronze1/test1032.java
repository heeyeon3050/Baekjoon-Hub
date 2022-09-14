package Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1032 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String arr[] = new String[N];
		boolean answer = true;
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		for(int i=0; i<arr[0].length(); i++) {
			for(int j=0; j<N-1; j++) {
				if(arr[0].charAt(i) == arr[j+1].charAt(i)) {
					answer = true;
				}
				else {
					answer = false;
					break;
				}
			}
			if(answer)
				sb.append(arr[0].charAt(i));
			else
				sb.append("?");
		}
		System.out.println(sb);
	}
}
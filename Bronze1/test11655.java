package Bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test11655 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		char arr[] = str.toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] >= 110)
				arr[i] -= 13;
			
			else if(arr[i] >= 97) 
				arr[i] += 13;
			
			else if(arr[i] >= 78) 
				arr[i] -= 13;
			
			else if(arr[i] >= 65){
				arr[i] += 13;
			}
		}
		
		for(int i=0; i<arr.length; i++)
			sb.append(arr[i]);
		
		System.out.println(sb);
	}
}

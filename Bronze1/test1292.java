package Bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test1292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int sum = 0;
		
		for(int i=0; i<1000; i++) {
			for(int j=0; j<=i; j++) {
				list.add(i+1);
			}
		}
		
		for(int i=a-1; i<=b-1; i++) {
			sum += list.get(i);
		}
		
		System.out.println(sum);
		
	}
}

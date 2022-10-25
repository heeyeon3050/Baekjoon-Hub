package Bronze2;

import java.io.IOException;

public class test15596 {
	public static void main(String[] args) throws IOException{
		int [] a = {1, 2, 3, 4};
		
		System.out.println(sum(a));
		
		
	}
	public static long sum(int[] a) {
		long sum = 0;
		for(int i=0; i<a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
}

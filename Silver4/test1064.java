package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1064 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int xy[][] = new int[4][4];
		double num[] = new double[4];
		double answer = 0;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<2; j++) {
				xy[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		if((xy[0][0]-xy[1][0])*(xy[0][1]-xy[2][1])==(xy[0][0]-xy[2][0])*(xy[0][1]-xy[1][1]))
			answer = -1;
		
		else {
			double a = Math.sqrt(Math.pow(xy[0][0]-xy[1][0],2)+Math.pow(xy[0][1]-xy[1][1], 2));
			double b = Math.sqrt(Math.pow(xy[0][0]-xy[2][0],2)+Math.pow(xy[0][1]-xy[2][1], 2));
			double c = Math.sqrt(Math.pow(xy[1][0]-xy[2][0],2)+Math.pow(xy[1][1]-xy[2][1], 2));
			
			num[0] = a + b;
			num[1] = a + c;
			num[2] = b + c;
			
			double max = Math.max(num[0], num[1]);
			max = Math.max(max, num[2]);
			
			double min = Math.min(num[0], num[1]);
			min = Math.min(min, num[2]);
			
			answer = 2*(max-min);
		}
		
		System.out.println(answer);
	}
}

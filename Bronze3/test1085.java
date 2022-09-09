package Bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1085 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int dis_x = 0;
		int dis_y = 0;
		
		/*
		if(x<=w/2)
			dis_x = x;
		else
			dis_x = w-x;
		
		if(y<=h/2)
			dis_y = y;
		else
			dis_y = h-y;
		*/
		
		 dis_x = Math.min(x, w-x);
		 dis_y = Math.min(y, h-y);
		
		System.out.println(Math.min(dis_x, dis_y));
	}
}

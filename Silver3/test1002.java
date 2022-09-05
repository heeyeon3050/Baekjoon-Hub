package Silver3;

import java.io.*;
import java.util.StringTokenizer;
//import java.util.Scanner;

public class test1002 {
	public static void main(String[] args) throws IOException {
		int a = 0, b = 0;
		//Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int c = Integer.parseInt(bf.readLine());
		int arr[] = new int[c];
		
		for(int i=0; i<c; i++) {
		st = new StringTokenizer(bf.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int r1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int cnt=0;
		/*
		for(a = -100; a<100; a++){
			for(b=-100; b<100; b++){
				if(((r1*r1)+(2*a*x1)-(x1*x1)+(2*b*y1)-(y1*y1))
						== ((r2*r2)+(2*a*x2)-(x2*x2)+(2*b*y2)-(y2*y2))) {
					if(((a*a)-(2*a*x1)+(x1*x1)+(b*b)-(2*b*y1)+(y1*y1)) == r1*r1) {
					cnt++;
					}
				}
			}
		}
		*/
		
		double d = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		//접점이 무한일 때
		if(d==0 && r1==r2)
			cnt = -1;
		
		//접점이 없을 때
		//1. 두 점사이의 거리가 두 반지릌의 합보다 클 때
		//2. 한 원 안에 다른 원이 있을 때
		else if(d > r1+r2 || d < Math.abs(r1-r2))
			cnt = 0;
		
		//접점이 한 개일 때
		//1.내접할 때	2.외접할 때
		else if(d == Math.abs(r1-r2) || d == r1+r2)
			cnt = 1;
		
		//접점이 두 개일 때
		else
			cnt = 2;
		
		arr[i] = cnt;
		}
		
		for(int i=0; i<c; i++)
			System.out.println(arr[i]);
	}
}

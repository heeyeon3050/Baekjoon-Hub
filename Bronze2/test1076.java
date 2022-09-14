package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1076 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String color[] = new String[3];
		color[0] = br.readLine();
		color[1] = br.readLine();
		color[2] = br.readLine();
		
		for(int i=0; i<2; i++) {
			switch(color[i]) {
			case "black" :
				sb.append(0);
				break;
				
			case "brown" :
				sb.append(1);
				break;
			
			case "red" :
				sb.append(2);
				break;
				
			case "orange" :
				sb.append(3);
				break;
				
			case "yellow" :
				sb.append(4);
				break;
				
			case "green" :
				sb.append(5);
				break;
				
			case "blue" :
				sb.append(6);
				break;
				
			case "violet" :
				sb.append(7);
				break;
				
			case "grey" :
				sb.append(8);
				break;
				
			case "white" :
				sb.append(9);
				break;
			}
		}
		
		long num = Integer.parseInt(sb.toString());

		switch(color[2]) {
		case "black" :
			break;
			
		case "brown" :
			num *= 10;
			break;
		
		case "red" :
			num *= 100;
			break;
			
		case "orange" :
			num *= 1000;
			break;
			
		case "yellow" :
			num *= 10000;
			break;
			
		case "green" :
			num *= 100000;
			break;
			
		case "blue" :
			num *= 1000000;
			break;
			
		case "violet" :
			num *= 10000000;
			break;
			
		case "grey" :
			num *= 100000000;
			break;
			
		case "white" :
			num *= 1000000000;
			break;
		}
		
		System.out.println(num);
	}
}

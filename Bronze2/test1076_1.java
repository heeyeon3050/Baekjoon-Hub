package Bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test1076_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		
		ArrayList<String> list = new ArrayList<>();
		list.add("black");
		list.add("brown");
		list.add("red");
		list.add("orange");
		list.add("yellow");
		list.add("green");
		list.add("blue");
		list.add("violet");
		list.add("grey");
		list.add("white");
		
		long answer = 0;
		answer += list.indexOf(a)*10;
		answer += list.indexOf(b);
		answer *= Math.pow(10, list.indexOf(c));
		
		System.out.println(answer);
	}
}

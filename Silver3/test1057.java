package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1057 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Kim = Integer.parseInt(st.nextToken());
		int Leem = Integer.parseInt(st.nextToken());
		int cnt=0;
		
		while(Kim != Leem) {
			Kim = Kim/2 + Kim%2;
			Leem = Leem/2 + Leem%2;
			cnt++;
		}
		System.out.println(cnt);
	}
}

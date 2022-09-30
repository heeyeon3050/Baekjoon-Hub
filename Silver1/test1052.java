package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1052 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer=0;
		
		while(true) {
			int cnt=0;
			int num = N;
			while(num>0) { //다 모았을 때의 물병 개수
				if(num%2==1) {
					cnt++;
				}
				num /= 2;
			}
			if(cnt<=K) {
				System.out.println(answer);
				break;
			}
			else {
				answer++; //상점에서 사야하는 물병 개수
				N++; //가지고 있는 물병 개수
			}
		}
	}
}
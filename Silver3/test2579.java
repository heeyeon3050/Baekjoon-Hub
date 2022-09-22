package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2579 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int stair[] = new int[n+1];
		int num = 0;
		stair[0] = 0;
		for(int i=1; i<=n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		int x = n;
		while(x>0) {
			if(stair[x-2]==0) {
				num+=stair[x-1];
				break;
			}
			
			else if(stair[x-1]==0) {
				break;
			}
			num += Math.max(stair[x-1], stair[x-2]);
			if(x == stair[x-1]) {
				x = x-1;
			}
			else
				x = x-2;
		}
	}
}

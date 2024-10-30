import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if(n % 2 != 0)
			System.out.println(0);
		else {
			int[] dp = new int[n+1];

			dp[0] = 1; //타일이 없을 경우도 경우의 수 포함
			dp[1] = 0;
			dp[2] = 3;

			for(int i=4; i<=n; i+=2){
				dp[i] = dp[i-2] * dp[2];
				for(int j=i-4; j>=0; j-=2){ //4이후로 또다른 경우의 수가 2개씩 생김
					dp[i] += (dp[j] * 2); //dp[6]일 때, dp[2]*2 + dp[0]*2
				}
			}
			System.out.println(dp[n]);
		}
	}
}
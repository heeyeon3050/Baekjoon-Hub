import java.io.*;
import java.util.*;

public class Main {
	static char[] str1;
	static char[] str2;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();

		dp = new int[str1.length+1][str2.length+1];

		// bottom-up
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					if (dp[i - 1][j] > dp[i][j - 1]) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int i = str1.length;
		int j = str2.length;
		while(i > 0 && j > 0){
			if(str1[i-1] == str2[j-1]){
				sb.append(str1[i-1]);
				i--;
				j--;
			} else if(dp[i-1][j] > dp[i][j-1])
				i--;
			else
				j--;
		}

		//top-down
		//LCS(str1.length, str2.length);

		System.out.println(dp[str1.length][str2.length]);
		System.out.println(sb.reverse());
	}

	//top-down. str 2차원 배열 써서 메모리 초과 날 수 있음.
	// public static int LCS(int x, int y) {
	// 	if (dp[x][y] > 0) {
	// 		return dp[x][y];
	// 	}
	//
	// 	if (x == 0 || y == 0) {
	// 		return 0;
	// 	}
	//
	// 	if (str1[x - 1] == str2[y - 1]) {
	// 		dp[x][y] = LCS(x - 1, y - 1) + 1;
	// 		str[x][y] = str[x - 1][y - 1] + str1[x - 1]; // 공통 문자를 추가
	// 	} else {
	// 		if (LCS(x - 1, y) > LCS(x, y - 1)) {
	// 			dp[x][y] = dp[x - 1][y];
	// 			str[x][y] = str[x - 1][y];
	// 		} else {
	// 			dp[x][y] = dp[x][y - 1];
	// 			str[x][y] = str[x][y - 1];
	// 		}
	// 	}
	//
	// 	return dp[x][y];
	// }
}
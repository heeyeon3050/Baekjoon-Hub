import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static char[][] arr;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];

		for(int i=0; i<n; i++){
			arr[i] = br.readLine().toCharArray();
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(j < n-1){
					swap(i, j, i, j+1);
					checkLong();
					swap(i, j, i, j+1);
				}

				if(i < n-1){
					swap(i, j, i+1, j);
					checkLong();
					swap(i, j, i+1, j);
				}
			}
		}

		System.out.println(max);
	}

	public static void swap(int x1, int y1, int x2, int y2){
		char temp = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = temp;
	}

	public static void checkLong(){
		for(int i=0; i<n; i++){
			int cnt1 = 1;
			int cnt2 = 1;
			for(int j=1; j<n; j++){
				if(arr[i][j] == arr[i][j-1]) {
					cnt1++;
					max = Math.max(max, cnt1);
				}
				else{
					cnt1 = 1;
				}

				if(arr[j][i] == arr[j-1][i]) {
					cnt2++;
					max = Math.max(max, cnt2);
				}
				else{
					cnt2 = 1;
				}
			}
		}
	}
}
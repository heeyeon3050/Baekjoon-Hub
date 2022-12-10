package Silver3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test3085 {
	static int N;
	static char arr[][];
	static int max = -1;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		//가로
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				char temp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = temp;
				
				search();
				
				temp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = temp;
			}
		}
		
		//세로
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				char temp = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = temp;
				
				max = Math.max(search(), max);
				
				temp = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = temp;
			}
		}
		
		System.out.println(max);
	}
	
	 public static int search() {
	        // 가로
	        for(int i = 0; i < N; i++) {
	            int cnt = 1;
	            for(int j = 0; j < N-1; j++) {
	                if(arr[i][j] == arr[i][j+1]) {
	                    cnt++;
	                } else {
	                    cnt = 1;
	                }
	                max = Math.max(max, cnt);
	            }
	        }

	        // 세로
	        for(int i = 0; i < N; i++) {
	            int cnt = 1;
	            for(int j = 0; j < N-1; j++) {
	                if(arr[j][i] == arr[j+1][i]) {
	                    cnt++;
	                } else {
	                    cnt = 1;
	                }
	                max = Math.max(max, cnt);
	            }
	        }

	        return max;
	    }
}

package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class test16935 {
	static int N, M;
	static int arr[][];
	static int matrix[][]; //three() ÀÌ¿כ
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		matrix = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			int num = Integer.parseInt(st.nextToken());
			switch(num) {
				case 1 : 
					one();
					break;
				case 2 : 
					two();
					break;
				case 3 : 
					three();
					break;
				case 4 : 
					four();
					break;
				case 5 : 
					five();
					break;
				case 6 : 
					six();
					break;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void one() {
		arr = new int[N][M];
		Stack<Integer> stack = new Stack<>();
		for(int j=0; j<M; j++) {
			for(int i=0; i<N; i++) {
				stack.push(matrix[i][j]);
			}
			for(int i=0; i<N; i++) {
				arr[i][j] = stack.pop();
			}
		}
		matrix = arr;
	}
	
	public static void two() {
		arr = new int[N][M];
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				stack.push(matrix[i][j]);
			}
			for(int j=0; j<M; j++) {
				arr[i][j] = stack.pop();
			}
		}
		matrix = arr;
	}
	
	public static void three() {
		arr = new int[M][N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = matrix[N-j-1][i];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		
		matrix = arr;
	}
	
	public static void four() {
		arr = new int[M][N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = matrix[j][M-i-1];
			}
		}
		int temp = N;
		N = M;
		M = temp;
		
		matrix = arr;
	}
	
	public static void five() {
		arr = new int[N][M];
		//1->2
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				arr[i][j+M/2] = matrix[i][j];
			}
		}
		
		//2->3
		for(int i=0; i<N/2; i++) {
			for(int j=M/2; j<M; j++) {
				arr[i+N/2][j] = matrix[i][j];
			}
		}
		
		//3->4
		for(int i=N/2; i<N; i++	) {
			for(int j=M/2; j<M; j++) {
				arr[i][j-M/2] = matrix[i][j];
			}
		}
		
		//4->1
		for(int i=N/2; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				arr[i-N/2][j] = matrix[i][j];
			}
		}
		
		matrix = arr;
	}
	
	public static void six() {
		arr = new int[N][M];
		//1->4
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M/2; j++) {
				arr[i+N/2][j] = matrix[i][j];
			}
		}
		
		//4->3
		for(int i=N/2; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				arr[i][j+M/2] = matrix[i][j];
			}
		}
		
		//3->2
		for(int i=N/2; i<N; i++) {
			for(int j=M/2; j<M; j++) {
				arr[i-N/2][j] = matrix[i][j];
			}
		}
		
		for(int i=0; i<N/2; i++) {
			for(int j=M/2; j<M; j++) {
				arr[i][j-M/2] = matrix[i][j];
			}
		}
		matrix = arr;
	}
}

import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if(!nextPermutation())
			System.out.println(-1);
		else {
			for(int i : arr){
				System.out.print(i + " ");
			}
		}
	}

	public static boolean nextPermutation(){
		int i = arr.length - 1;
		while(i > 0 && arr[i-1] <= arr[i])
			i--;

		if(i == 0)
			return false;

		int j = arr.length - 1;
		while(arr[i-1] <= arr[j])
			j--;

		swap(i-1, j);

		j = arr.length - 1;
		while(i < j){
			swap(i, j);
			i++;
			j--;
		}

		return true;
	}

	public static void swap(int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
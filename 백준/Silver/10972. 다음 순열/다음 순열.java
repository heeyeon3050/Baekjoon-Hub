import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (nextPermutation()) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
		
	}
	
	public static boolean nextPermutation() {
		int i = arr.length - 1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		if(i <= 0) return false;
		
		
		int j = arr.length - 1;
		while(arr[j] <= arr[i - 1]) j--;
		
		swap(i-1, j);
		j = arr.length-1;
		while(i < j) {
			swap(i, j);
			i++; j--;
		}
		return true;
	}
	
	public static void swap(int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}

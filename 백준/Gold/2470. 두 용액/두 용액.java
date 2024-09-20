import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int num1 = 0, num2 = 0;
		int start = 0;
		int end = n-1;
		int min = Integer.MAX_VALUE;

		while(start < end){
			int sum = arr[start] + arr[end];

			if(min > Math.abs(sum)){
				min = Math.abs(sum);

				num1 = arr[start];
				num2 = arr[end];

				if(min == 0)
					break;
			}

			if(sum < 0)
				start++;
			else
				end--;
		}

		System.out.println(num1 + " " + num2);
	}
}
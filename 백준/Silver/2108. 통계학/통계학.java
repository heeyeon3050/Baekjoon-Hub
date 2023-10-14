import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] cnt = new int[8001];

		int sum = 0;
		for(int i=0; i<N; i++){
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			cnt[arr[i]+4000]++;
		}
		sb.append(Math.round((double)sum/N) + "\n");

		Arrays.sort(arr);
		sb.append(arr[arr.length/2] + "\n");

		int max = 0;
		int mode = 0;
		boolean flag = false;

		for(int i=arr[0]+4000; i<=arr[arr.length-1]+4000; i++){
			if(cnt[i] < 0) continue;

			if(max < cnt[i]){
				max = cnt[i];
				mode = i - 4000;
				flag = true;
			} else if(max == cnt[i] && flag){
				mode = i - 4000;
				flag = false;
			}
		}

		sb.append(mode + "\n");

		sb.append(arr[arr.length-1] - arr[0]);

		System.out.println(sb);
	}
}
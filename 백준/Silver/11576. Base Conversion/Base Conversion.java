import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[m];
		for(int i=0; i<m; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int num = 1;
		for(int i=m-1; i>=0; i--){
			sum += arr[i] * num;
			num *= a;
		}

		List<Integer> list = new ArrayList<>();
		while(sum != 0){
			int remainder = sum % b;
			sum = sum / b;
			
			list.add(remainder);
		}

		int size = list.size();
		for(int i=size-1; i>=0; i--){
			sb.append(list.get(i)).append(" ");
		}

		System.out.println(sb);
	}
}
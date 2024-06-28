import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] temp = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		temp = arr.clone();

		Arrays.sort(arr);

		Map<Integer, Integer> map = new HashMap<>();

		int num = 0;
		for(int i=0; i<n; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], num++);
			}
		}

		for(int i=0; i<n; i++){
			sb.append(map.get(temp[i]) + " ");
		}

		System.out.println(sb);
	}
}
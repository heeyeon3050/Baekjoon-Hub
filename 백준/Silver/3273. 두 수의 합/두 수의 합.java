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
		
		Integer[] arr = new Integer[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		Arrays.sort(arr, (o1, o2) -> Integer.compare(o1, o2));
		
		int left=0, right=n-1;
        while(left < right) {
            int sum = arr[left]+arr[right];
            if(sum == x) {    // 같다면 count
                cnt++;
                left++;
                right--;
            }else if(sum > x) {    // 더 크다면
                right--;
            }else {    // 더 작다면
                left++;
            }
        }
		
		System.out.println(cnt);
	}
}
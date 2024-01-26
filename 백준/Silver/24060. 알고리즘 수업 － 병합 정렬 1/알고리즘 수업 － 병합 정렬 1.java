import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tmp;
	static int cnt = 0;
	static int result = -1;
	static int K = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int A[] = new int[N];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		merge_sort(A, 0, N-1);
		System.out.println(result);
	}
	
	public static void merge_sort(int[] A, int p, int r) {
		if(p < r) {
			int q = (p+r)/2;
			merge_sort(A, p, q);
			merge_sort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	
	public static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q+1;
		int t = 0;
		while(i <= q && j <= r) {
			if(A[i] <= A[j])
				tmp[t++] = A[i++];
			else
				tmp[t++] = A[j++];
		}
		
		while(i <= q)
			tmp[t++] = A[i++];
		
		while(j <= r)
			tmp[t++] = A[j++];
		
		i = p;
		t = 0;
		while(i <= r) {
			A[i++] = tmp[t++];
			cnt++;
			if(cnt == K) {
				result = tmp[t-1];
				break;
			}
		}
	}
}
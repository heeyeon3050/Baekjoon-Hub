import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sushi = new int[d+1];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0, sum = 0;
        sushi[c]++;
        sum++;
        for (int i = 0; i < k; i++) {
            if(sushi[arr[i % N]]++ == 0) sum++;
        }
        max = sum;
        for(int i = 0; i < N; i++) {
            if(sushi[arr[(i + k) % N]]++ == 0) sum++;
            if(--sushi[arr[i]] == 0) sum--;
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
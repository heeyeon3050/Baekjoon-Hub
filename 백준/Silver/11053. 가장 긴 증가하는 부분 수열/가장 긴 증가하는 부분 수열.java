import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(A[i] > A[j] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j]+1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            max = Math.max(max, dp[i]);
        }

        System.out.println(max+1);
    }
}
package Silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];

            for(int j=0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for(int j=0; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    sum += gcd(arr[j], arr[k]);
                }
            }

            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }

    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
}

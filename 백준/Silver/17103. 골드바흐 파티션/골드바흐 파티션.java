import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean prime[] = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        func();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            int cnt = 0;
            for(int i=2; i<=N/2; i++){
                if(!prime[i] && !prime[N-i]){
                    cnt++;
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }

    public static void func(){
        for(int i=2; i<=1000000/2; i++){
            for(int j=i*2; j<=1000000; j+=i){
                prime[j] = true; //소수 아님
            }
        }
    }
}
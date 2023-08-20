import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time,  Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[0]));

        int cnt = 0;
        int end = 0;

        for(int i=0; i<N; i++){
            if(end <= time[i][0]) {
                cnt++;
                end = time[i][1];
            }
        }

        System.out.println(cnt);
    }
}

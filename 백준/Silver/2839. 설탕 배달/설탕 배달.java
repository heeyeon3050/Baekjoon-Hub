import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		int min = N;

        for(int i=0; i<=N/5; i++) {
            for(int j=0; j<=N/3; j++) {
                if((5*i + 3*j)==N) {
                    cnt = i+j;
                    if(cnt < min)
                        min = cnt;
                }
            }
		}
		
		if(min == N)
			min = -1;
		System.out.println(min);
	}
}
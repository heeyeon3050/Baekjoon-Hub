package Silver4;

<<<<<<< HEAD
import java.util.Scanner;

public class test2839 {

	public static void main(String[] args) {
		System.out.println("배달할려는 설탕의 무게 : ");
		Scanner s = new Scanner(System.in);
		int weight = s.nextInt();
		int num;
		int i, j, a, min=weight;
		int max = weight/3;
		for(i=0; i<=max; i++) {
			for(j=0; j<=max; j++) {
				num = 3*i + 5*j;
				if(num == weight) {
					a = i+j;
					if(a<min)
						min = a;
				}
			}
		}
		if(min == weight)
			min = -1;
		System.out.println("배달하는 봉지의 최소 개수 : " + min);
	}
}


=======
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test2839 {
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
>>>>>>> 88c970352ff5a2f6dcb0e0dda01a9ac8973eab1d

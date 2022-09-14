package Bronze1;

import java.util.Scanner;

public class test4344 {

	public static void main(String[] args) {
		System.out.println("테스트 케이스의 개수 : ");
		Scanner s = new Scanner(System.in);
		int c = s.nextInt();
		int sum[] = new int[c];
		int avg[] = new int[c];
		int score[][] = new int[1000][100];
		int i, j;
		int count;
		
		for(i=0; i<c; i++) {
			Scanner sc = new Scanner(System.in);
			score[i][0] = sc.nextInt();
			for(j=1; j<=score[i][0]; j++) {
				score[i][j]=sc.nextInt();
				sum[i] += score[i][j];
			}
		}
		
		for(i=0; i<c; i++) {
			count=0;
			avg[i] = sum[i]/score[i][0];
			for(j=1; j<=score[i][0]; j++) {
				if(score[i][j]>avg[i])
					count++;
			}
			System.out.println(String.format("%.3f", (double)count/score[i][0]*100) + "%");
		}
	}
}


import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		if(n == 0){
			System.out.println(0);
		} else {
			while (n != 0){
				int remainder = n % -2; // -2진번 이므로 -2로 나눔
				n = n / -2; //나눈 몫으로 바꿔줌

				if(remainder < 0){
					remainder += 2;
					n += 1;
				}

				sb.append(remainder);
			}
		}

		System.out.println(sb.reverse()); //역순으로 읽어야 가장 마지막에 구한 나머지가 왼쪽에 위치
	}
}
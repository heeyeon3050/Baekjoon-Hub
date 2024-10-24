import java.io.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 방법 1
		// String str = br.readLine();
		// BigInteger OctalToDecimal = new BigInteger(str, 8);
		// System.out.println(OctalToDecimal.toString(2));

		String[] arr = {"000","001","010","011","100","101","110","111"};
		String str = br.readLine();
		int length = str.length();

		for(int i=0; i<length; i++){
			sb.append(arr[str.charAt(i)-'0']);
		}

		if(str.equals("0"))
			System.out.println(str);
		else{
			while(sb.charAt(0) == '0')
				sb = new StringBuilder(sb.substring(1));
			System.out.println(sb);
		}
	}
}
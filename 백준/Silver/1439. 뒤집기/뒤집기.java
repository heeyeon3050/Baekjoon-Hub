import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int length = str.length();

		int cnt0 = 0;
		int cnt1 = 0;
		char prev = str.charAt(0) == '0' ? '1' : '0';
		for(int i=0; i<length; i++){
			if(str.charAt(i) == prev)
				continue;
			if(str.charAt(i) == '0') {
				cnt0++;
			}
			else {
				cnt1++;
			}
			prev = str.charAt(i);
		}

		System.out.println(Math.min(cnt0, cnt1));
	}
}
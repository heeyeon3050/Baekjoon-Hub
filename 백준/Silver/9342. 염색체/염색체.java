import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		String rule = "^[A-F]?A+F+C+[A-F]?$";

		for(int tc=0; tc<T; tc++){
			String str = br.readLine();
			if(str.matches(rule))
				sb.append("Infected!\n");
			else
				sb.append("Good\n");
		}

		System.out.println(sb);
	}
}
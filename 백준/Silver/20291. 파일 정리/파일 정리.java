import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		for(int i=0; i<N; i++){
			String str = br.readLine();

			for(int j=0; j<str.length(); j++){
				if(str.charAt(j) == '.'){
					map.put(str.substring(j+1), map.getOrDefault(str.substring(j+1), 0) + 1);
				}
			}
		}

		List<String> list = new ArrayList<>();
		for (String s : map.keySet()) {
			list.add(s + " " + map.get(s) + "\n");
		}

		Collections.sort(list, (o1, o2) -> {
			return o1.compareTo(o2);
		});

		for(int i=0; i<list.size(); i++){
			sb.append(list.get(i));
		}

		System.out.println(sb);
	}
}
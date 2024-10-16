import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] list;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];

		for(int i=0; i<n; i++){
			list[i] = new ArrayList<>();
		}

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			while(num != -1){
				list[i].add(num);
				num = Integer.parseInt(st.nextToken());
			}
		}

		int k = 0;
		while(!check(k++)) set.clear();

		System.out.println(k);
	}

	public static boolean check(int k){
		for(List<Integer> l : list){
			if(k < l.size()){
				if(set.contains(l.get(k)))
					return false;
				set.add(l.get(k));
			}
		}
		return true;
	}
}
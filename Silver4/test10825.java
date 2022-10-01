package Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class test10825 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		String score[][] = new String[N][4];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			score[i][0] = st.nextToken();
			score[i][1] = st.nextToken();
			score[i][2] = st.nextToken();
			score[i][3] = st.nextToken();
		}
		
		Arrays.sort(score, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[1].equals(o2[1])) {
					if(o1[2].equals(o2[2])) {
						if(o2[3].equals(o1[3])) {
							return o1[0].compareTo(o2[0]);
						}
						return Integer.parseInt(o2[3])-Integer.parseInt(o1[3]);
					}
					return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]);
				}
				return Integer.parseInt(o2[1])-Integer.parseInt(o1[1]);
			}
		});
		
		for(int i=0; i<N; i++){
			System.out.println(score[i][0]);
		}
	}
}

package Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class test2529 {
	static int k;
	static char arr[];
	static boolean visit[];
	static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		k = Integer.parseInt(br.readLine());
		
		arr = new char[k];
		visit = new boolean[10];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		dfs("", 0);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
	
	public static void dfs(String num, int cnt) {
		if(cnt==k+1) {
			list.add(num);
			return;
		}
		else {
			for(int i=0; i<=9; i++) {
				if(!visit[i]) {
					if(cnt==0 || check(num.charAt(num.length()-1)-'0', i, arr[cnt-1])) {
						visit[i] = true;
						dfs(num+i, cnt+1);
						visit[i] = false;
					}
				}
			}
		}
	}
	
	public static boolean check(int a, int b, char c) {
		if(c=='<')
			return a<b;
		else
			return a>b;
	}
}

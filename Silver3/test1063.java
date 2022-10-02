package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1063 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		String king[] = new String[2];
		king = st.nextToken().split("");
		char a = king[0].charAt(0);
		int b = Integer.parseInt(king[1]);
		String doll[] = new String[2];
		doll = st.nextToken().split("");
		char x = doll[0].charAt(0);
		int y = Integer.parseInt(doll[1]);
		int N = Integer.parseInt(st.nextToken());
		String move[] = new String[N];
		
		for(int i=0; i<N; i++) {
			move[i] = br.readLine();
		}
		
		for(int i=0; i<N; i++) {
			switch(move[i]) {
			case "R" :
				if(a=='H')
					break;
				else if(a+1==x && b==y) {
					if(x=='H')
						break;
					else {
						a++; x++;
						break;
					}
				}
				else {
					a++;
					break;
				}
			case "L" :
				if(a=='A')
					break;
				else if(a-1==x && b==y) {
					if(x=='A')
						break;
					else {
						a--; x--;
						break;
					}
				}
				else {
					a--;
					break;
				}
			case "B" :
				if(b==1)
					break;
				else if(a==x && b-1==y) {
					if(y==1)
						break;
					else {
						b--; y--;
						break;
					}
				}
				else {
					b--;
					break;
				}
			case "T" :
				if(b==8)
					break;
				else if(a==x && b+1==y) {
					if(y==8)
						break;
					else {
						b++; y++;
						break;
					}
				}
				else {
					b++;
					break;
				}
			case "RT" :
				if(a=='H' || b==8)
					break;
				else if(a+1==x && b+1==y) {
					if(x=='H' || y==8)
						break;
					else {
						a++; b++; x++; y++;
						break;
					}
				}
				else {
					a++; b++;
					break;
				}
			case "LT" :
				if(a=='A' || b==8)
					break;
				else if(a-1==x && b+1==y) {
					if(x=='A' || y==8)
						break;
					else {
						a--; b++; x--; y++;
						break;
					}
				}
				else {
					a--; b++;
					break;
				}
			case "RB" :
				if(a=='H' || b==1)
					break;
				else if(a+1==x && b-1==y) {
					if(x=='H' || y==1)
						break;
					else {
						a++; b--; x++; y--;
						break;
					}
				}
				else {
					a++; b--;
					break;
				}
			case "LB" :
				if(a=='A' || b==1)
					break;
				else if(a-1==x && b-1==y) {
					if(x=='A' || y==1) 
						break;
					else {
						a--; b--; x--; y--;
						break;
					}
				}
				else {
					a--; b--;
					break;
				}
			}
		}
		sb.append(a).append(b).append('\n');
		sb.append(x).append(y);
		System.out.println(sb);
	}
}

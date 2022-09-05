package Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1004 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int arr[] = new int[T];
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			int cnt=0;
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				//출발점과 도착점이 둘 다 행성계 안에 있을 경우 continue
				if(Math.pow(x1-cx, 2)+Math.pow(y1-cy, 2) < Math.pow(r, 2) && Math.pow(x2-cx, 2)+Math.pow(y2-cy, 2) < Math.pow(r, 2)){
						continue;
					}
				//둘 중 하나만 안에 있을 경우 count
				else if(Math.pow(x1-cx, 2)+Math.pow(y1-cy, 2) < Math.pow(r, 2) || Math.pow(x2-cx, 2) + Math.pow(y2-cy, 2) < Math.pow(r, 2)) {
					cnt++;
				}
			}
			arr[i] = cnt;
		}
		for(int i=0; i<T; i++)
			System.out.println(arr[i]);
	}
}

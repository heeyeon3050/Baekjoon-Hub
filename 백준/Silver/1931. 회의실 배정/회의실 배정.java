import java.io.*;
import java.util.*;

public class Main {
	static class Time implements Comparable<Time>{
		int start, end;

		public Time(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Time o2){
			if(this.end == o2.end){
				return Integer.compare(this.start, o2.start);
			} else
				return Integer.compare(this.end, o2.end);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Time[] arr = new Time[N];

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Time(a, b);
		}

		Arrays.sort(arr);

		int cnt = 0, i = 1;
		int e_time = arr[0].end;

		while(i < N){
			if(e_time <= arr[i].start){
				e_time = arr[i].end;
				cnt++;
			}
			i++;
		}

		System.out.println(cnt+1);
	}
}
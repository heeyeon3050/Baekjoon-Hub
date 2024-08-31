import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		List<Integer> crane = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			crane.add(Integer.parseInt(st.nextToken()));

		int m = Integer.parseInt(br.readLine());

		List<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<m; i++)
			box.add(Integer.parseInt(st.nextToken()));

		crane.sort(Collections.reverseOrder());
		box.sort(Collections.reverseOrder());

		if(crane.get(0) < box.get(0)){
			System.out.println(-1);
			return;
		}

		int day = 0;
		while(!box.isEmpty()){
			int boxIdx = 0, craneIdx = 0;

			while(craneIdx < n && boxIdx < box.size()){
				if(crane.get(craneIdx) >= box.get(boxIdx)){
					box.remove(boxIdx); //해당 인덱스가 삭제되면서 자동으로 다음 인덱스를 가리킴
					craneIdx++;
				}
				else
					boxIdx++;
			}

			day++;
		}

		System.out.println(day);
	}
}
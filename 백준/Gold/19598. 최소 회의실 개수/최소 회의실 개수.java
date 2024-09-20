import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static class Pair{
		int s, e;

		Pair(int s, int e){
			this.s = s;
			this.e = e;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Pair[] arr = new Pair[n];

		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			arr[i] = new Pair(s, e);
		}

		compress(arr);

		int[] num = new int[222222]; //n이 최대 100000이므로 시작 시간과 끝나는 시간 고려하면 200000 넉넉하게 필요함.
		for(Pair p : arr){
			num[p.s] += 1;
			num[p.e] -= 1;
		}

		for(int i=0; i<222221; i++){
			num[i+1] += num[i];
		}

		int max = 0;
		for(int i=0; i<222222; i++){
			max = Math.max(max, num[i]);
		}

		System.out.println(max);
	}

	public static void compress(Pair[] arr){
		Map<Integer, Integer> map = new TreeMap<>();

		for(Pair p : arr){
			map.put(p.s, 0);
			map.put(p.e, 0);
		}

		int num = 0;
		for(int key : map.keySet()){
			if(map.get(key) != 0)
				continue;
			map.put(key, num++);
		}

		for(Pair p : arr){
			p.s = map.get(p.s);
			p.e = map.get(p.e);
		}
	}

	public static void compress1(Pair[] arr){
		Map<Integer, Integer> map = new HashMap<>();

		for(Pair p : arr){
			map.put(p.s, 0);
			map.put(p.e, 0);
		}

		int[] temp = new int[map.size()];
		int num = 0;
		for(int key : map.keySet()){
			temp[num++] = key;
		}
		Arrays.sort(temp);

		num = 0;
		for(int i=0; i<temp.length; i++){
			map.put(temp[i], num++);
		}

		for (Pair p: arr) {
			p.s = map.get(p.s);
			p.e = map.get(p.e);
		}
	}
}
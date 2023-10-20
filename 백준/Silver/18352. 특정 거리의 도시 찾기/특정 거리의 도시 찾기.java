import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static List<List<City>> list = new ArrayList<>();
	static int N, M, K, X;
	static int[] dist;

	static class City implements Comparable<City>{
		int cityNum;
		int weight;

		public City(int cityNum, int weight){
			this.cityNum = cityNum;
			this.weight = weight;
		}

		@Override
		public int compareTo(City o){
			return weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		dist = new int[N+1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		for(int i=0; i<=N; i++){
			list.add(new ArrayList<>());
		}

		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			list.get(A).add(new City(B, 1));
		}

		dijkstra(X);

		for(int i=1; i<dist.length; i++){
			if(dist[i] == K){
				sb.append(i).append("\n");
			}
		}

		if(sb.length() == 0)
			System.out.println(-1);
		else
			System.out.println(sb);
	}

	private static void dijkstra(int cityNum) {
		PriorityQueue<City> que = new PriorityQueue<>();
		boolean visit[] = new boolean[N+1];
		dist[cityNum] = 0;

		que.offer(new City(cityNum, 0));

		while( !que.isEmpty() ) {
			City city = que.poll();
			int num = city.cityNum;

			if(visit[num]) continue;

			visit[num] = true;

			for(City c : list.get(num)) {

				if( !visit[c.cityNum] && dist[c.cityNum] > (c.weight + dist[num]) ) {
					dist[c.cityNum] = c.weight + dist[num];
					que.offer(new City(c.cityNum, dist[c.cityNum]));
				}
			}
		}
	}
}
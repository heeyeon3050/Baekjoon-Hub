import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, D;
    static List<Edge>[] adjList;

    public static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        adjList = new List[D + 1];
        for (int i = 0; i <= D; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 기본 도로 연결
        for (int i = 0; i <= D - 1; i++) {
            adjList[i].add(new Edge(i + 1, 1));
        }

        // 지름길 연결
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (end <= D) {
                adjList[start].add(new Edge(end, cost));
            }
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        pq.offer(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (dist[curr.to] < curr.cost) continue;

            for (Edge next : adjList[curr.to]) {
                if (dist[next.to] > dist[curr.to] + next.cost) {
                    dist[next.to] = dist[curr.to] + next.cost;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }

        return dist[D];
    }
}
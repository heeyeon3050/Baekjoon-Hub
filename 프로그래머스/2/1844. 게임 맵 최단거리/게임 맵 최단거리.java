import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visit;

    class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {
        int answer = 1;
        int n = maps[0].length;
        int m = maps.length;
        visit = new boolean[m][n];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visit[0][0] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                for(int j=0; j<4; j++){
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if(nx == n-1 && ny == m-1){
                        return answer+1;
                    }
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[ny][nx] && maps[ny][nx]==1){
                        visit[ny][nx] = true;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
            answer++;
        }
        return -1;
    }
}
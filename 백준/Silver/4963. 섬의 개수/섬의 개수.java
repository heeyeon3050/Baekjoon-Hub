import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {1, -1, 0, 0, -1, -1, 1, 1};
    static int dy[] = {0, 0, 1, -1, -1, 1, -1, 1};
    static int w, h;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        cnt++;
                        map[i][j] = 0;
                        dfs(i, j);
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int x, int y){
        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >=h || ny < 0 || ny >= w) continue;

            if(map[nx][ny] == 1){
                map[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }
}
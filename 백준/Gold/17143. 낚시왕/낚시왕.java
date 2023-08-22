import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Shark{
    int r, c, s, d, z;

    Shark(int r, int c, int s, int d, int z){
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

public class Main {
    static int dx[] = {-1, 0, 1, 0}; //상 좌 하 우
    static int dy[] = {0, -1, 0, 1};

    static int R, C;
    static Shark[][] map;
    static List<Shark> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new Shark[R+1][C+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            //상 좌 하 우
            if(d == 1)
                d = 0;
            else if(d == 4)
                d = 1;

            map[r][c] = new Shark(r, c, s, d, z);
        }


        int sum = 0;
        for(int i=1; i<=C; i++) {
            for(int j=1; j<=R; j++) {
                if(map[j][i] != null) {
                    sum += map[j][i].z;
                    map[j][i] = null;
                    break;
                }
            }

            list = new ArrayList<>();
            for(int j=1; j<=R; j++) {
                for(int k=1; k<=C; k++) {
                    if(map[j][k] != null)
                        list.add(new Shark(j, k, map[j][k].s, map[j][k].d, map[j][k].z));
                }
            }

            move();
        }
        System.out.println(sum);
    }

    public static void move() {
        map = new Shark[R+1][C+1];
        for(int i=0; i<list.size(); i++) {
            Shark shark = list.get(i);

            int speed = shark.s; //최소한의 이동
            if(shark.d == 0 || shark.d == 2) //상 하
                speed %= (R-1)*2;
            else if(shark.d == 1 || shark.d == 3) //좌 우
                speed %= (C-1)*2;

            for(int j=0; j<speed; j++) {
                int nx = shark.r + dx[shark.d];
                int ny = shark.c + dy[shark.d];

                if(nx <= 0 || nx > R || ny <= 0 || ny > C) {
                    shark.r -= dx[shark.d]; //다시 값 돌려줌
                    shark.c -= dy[shark.d];
                    shark.d = (shark.d + 2) % 4; //방향 반대로
                    continue;
                }
                shark.r = nx;
                shark.c = ny;
            }

            //새로운 위치에 상어가 있는지 확인
            if(map[shark.r][shark.c] != null) {
                if(map[shark.r][shark.c].z < shark.z) {
                    map[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.s, shark.d, shark.z);
                }
            } else {
                map[shark.r][shark.c] = new Shark(shark.r, shark.c, shark.s, shark.d, shark.z);
            }
        }
    }
}
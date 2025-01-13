import java.io.*;
import java.util.*;

public class Main {
    // 이건 지우는거 아님
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 사용 변수
    static int n;
    static int m;
    static int[][] map;

    // 로봇 위치
    static int r;
    static int c;
    static int d;

    // 순서!! -> 남, 동, 북, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 결과
    // 첫 칸은 항상 청소되어있음
    static int count = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r =  Integer.parseInt(st.nextToken());
        c =  Integer.parseInt(st.nextToken());
        d =  Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                // 0 -> 청소 x , 1 -> 벽
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(count);
    }

    static void clean(int r, int c, int d) {
        // 청소 되지 않은 경우 현재 칸을 청소한다.
        map[r][c] = -1;

        // 상하좌우 4칸을 관찰할거임
        for(int i = 0; i < 4; i++){
            // 반시계 방향으로 회전 시키기
            d = (d + 3) % 4;

            int nx = r + dx[d];
            int ny = c + dy[d];

            // 맵을 나가지 않고, 청소가 안된 경우
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0){
                // 청소했다 치고, 재귀 돌리면 다시 청소할거임
                count++;
                clean(nx, ny, d);
                return;
            }
        }

        // 4칸 관찰했는데 청소를 다한 경우

        // 한칸 후진이 가능하면 한 칸 후진
        // 후진 못하면 바로 작동 종료
        int dir = (d + 2) % 4;
        int bx = r + dx[dir];
        int by = c + dy[dir];
        if(bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1){
            clean(bx, by, d);   // 후진은 방향 유지임.
        }

        // 작동 종료
    }


}
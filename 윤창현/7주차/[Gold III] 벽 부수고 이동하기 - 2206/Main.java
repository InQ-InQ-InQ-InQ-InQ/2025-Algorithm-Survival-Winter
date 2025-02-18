import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    // 지워도 되는 변수들
    static int n;
    static int m;
    static int[][] map;
    static boolean[][][] visited;
    static int result = Integer.MIN_VALUE;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // 위치 변수
    static class Loc {
        int x;
        int y;
        int count;
        boolean isDestroy;  // 지금까지 벽을 부쉈는가?

        public Loc(int x, int y, int count, boolean isDestroy) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.isDestroy = isDestroy;
        }
    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m][2];     // 벽을 부순 경우 1, 부수지 않은 경우 0

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        Queue<Loc> queue = new LinkedList<>();

        queue.add(new Loc(0, 0, 1, false));
        while (!queue.isEmpty()) {
            Loc nowLoc = queue.poll();

            // 도착점에 도달한 경우
            if (nowLoc.x == n - 1 && nowLoc.y == m - 1) {
                System.out.println(nowLoc.count);
                return;
            }

            int nowX = nowLoc.x;
            int nowY = nowLoc.y;
            int nowCount = nowLoc.count;
            boolean nowIsDestroy = nowLoc.isDestroy;

            for (int i = 0; i < dx.length; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 먼저 다음 갈 곳을 생각하면서 문제를 해결한다.
                // 다음 갈 곳이 벽이 아니라면?
                if (map[nx][ny] == 0) {
                    // 아직까지 벽을 부수지 않았다면
                    if (!visited[nx][ny][0] && !nowIsDestroy) {
                        visited[nx][ny][0] = true;
                        queue.add(new Loc(nx, ny, nowCount + 1, false));
                    } else if (!visited[nx][ny][1] && nowIsDestroy) {
                        visited[nx][ny][1] = true;
                        queue.add(new Loc(nx, ny, nowCount + 1, true));
                    }
                } else if (map[nx][ny] == 1) {
                    if (!visited[nx][ny][1] && !nowIsDestroy) {
                        visited[nx][ny][1] = true;
                        queue.add(new Loc(nx, ny, nowCount + 1, true));
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
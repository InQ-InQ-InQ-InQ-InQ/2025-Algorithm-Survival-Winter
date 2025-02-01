package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_4963_Silver2_DFS {
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static int w, h;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // read
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            map = new boolean[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                StringTokenizer st1 = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int number = Integer.parseInt(st1.nextToken());
                    if (number == 1) {
                        map[i][j] = true;
                    }
                }
            }

            // logic
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void dfs(int y, int x) {
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < w && nextY < h) {
                if (!visited[nextY][nextX] && map[nextY][nextX]) {
                    dfs(nextY, nextX);
                }
            }
        }
    }
}

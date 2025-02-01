package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10026_Gold5_DFS {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // read
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // logic
        int count1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count1++;
                    dfs1(i, j, map[i][j]);
                }
            }
        }

        visited = new boolean[N][N];
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count2++;
                    dfs2(i, j, map[i][j]);
                }
            }
        }

        System.out.println(count1);
        System.out.println(count2);
    }

    private static void dfs1(int cy, int cx, char color) {
        if (visited[cy][cx]) {
            return;
        }
        visited[cy][cx] = true;

        for (int i = 0; i < 4; i++) {
            int ny = cy + dy[i];
            int nx = cx + dx[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[ny][nx] && map[ny][nx] == color) {
                    dfs1(ny, nx, color);
                }
            }
        }
    }

    private static void dfs2(int cy, int cx, char color) {
        if (visited[cy][cx]) {
            return;
        }
        visited[cy][cx] = true;

        for (int i = 0; i < 4; i++) {
            int ny = cy + dy[i];
            int nx = cx + dx[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[ny][nx]) {
                    if (isSameColorForColorBlind(color, ny, nx)) {
                        dfs2(ny, nx, color);
                    }
                }
            }
        }
    }

    private static boolean isSameColorForColorBlind(char color, int ny, int nx) {
        return map[ny][nx] == color || (map[ny][nx] == 'R' && color == 'G') || (map[ny][nx] == 'G' && color == 'R');
    }
}

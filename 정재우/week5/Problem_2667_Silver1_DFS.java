package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_2667_Silver1_DFS {
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // read
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                if (line.charAt(j) == '1') {
                    map[i][j] = true;
                }
            }
        }

        // logic
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j]) {
                    count = 1;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    private static void dfs(int cy, int cx) {
        if (visited[cy][cx]) {
            return;
        }
        visited[cy][cx] = true;

        for (int i = 0; i < 4; i++) {
            int ny = cy + dy[i];
            int nx = cx + dx[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[ny][nx] && map[ny][nx]) {
                    count++;
                    dfs(ny, nx);
                }
            }
        }
    }
}

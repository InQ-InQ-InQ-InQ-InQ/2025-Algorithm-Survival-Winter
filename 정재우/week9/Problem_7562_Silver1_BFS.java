package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_7562_Silver1_BFS {
    static int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
    static int[] dy = {-2, 2, -2, 2, 1, -1, 1, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];

            // knight
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int startI = Integer.parseInt(st1.nextToken());
            int startJ = Integer.parseInt(st1.nextToken());

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int endI = Integer.parseInt(st2.nextToken());
            int endJ = Integer.parseInt(st2.nextToken());

            // bfs
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startI, startJ});
            visited[startI][startJ] = true;

            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                int curI = poll[0];
                int curJ = poll[1];

                for (int k = 0; k < 8; k++) {
                    int nextI = poll[0] + dy[k];
                    int nextJ = poll[1] + dx[k];

                    if (nextI >= 0 && nextJ >= 0 && nextI < l && nextJ < l) {
                        if (!visited[nextI][nextJ]) {
                            // 최소 이동 거리를 갱신하거나, 방문한 적이 없을 경우 +1을 한다.
                            if (map[nextI][nextJ] <= map[curI][curJ] + 1 && map[nextI][nextJ] != 0) {
                                continue;
                            }
                            map[nextI][nextJ] = map[curI][curJ] + 1;
                            if (nextI == endI && nextJ == endJ) {
                                break;
                            }
                            queue.offer(new int[]{nextI, nextJ});
                        }
                    }
                }
            }

            System.out.println(map[endI][endJ]);
        }
    }
}

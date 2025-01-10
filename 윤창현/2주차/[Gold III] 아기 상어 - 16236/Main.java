import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n;
    static int[][] map;
    static boolean[][] visited;

    // 북 -> 서 -> 동 -> 남
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    static class BabyShark {
        int y, x, distance;

        public BabyShark(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    static BabyShark babyShark;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 9) {
                    babyShark = new BabyShark(i, j, 0);
                    map[i][j] = 0;
                } else {
                    map[i][j] = temp;
                }
            }
        }

        int size = 2, eat = 0, time = 0;

        while (true) {
            visited = new boolean[n][n]; // 매번 초기화
            PriorityQueue<BabyShark> pq = new PriorityQueue<>((o1, o2) ->
                    o1.distance != o2.distance ? Integer.compare(o1.distance, o2.distance)
                            : (o1.y == o2.y ? Integer.compare(o1.x, o2.x) : Integer.compare(o1.y, o2.y))
            );

            pq.offer(new BabyShark(babyShark.y, babyShark.x, 0));
            visited[babyShark.y][babyShark.x] = true;

            boolean eatCheck = false;

            while (!pq.isEmpty()) {
                BabyShark cur = pq.poll();

                if (map[cur.y][cur.x] != 0 && map[cur.y][cur.x] < size) {
                    map[cur.y][cur.x] = 0;
                    babyShark = new BabyShark(cur.y, cur.x, 0);
                    eat++;
                    time += cur.distance;
                    eatCheck = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] || map[ny][nx] > size)
                        continue;
                    pq.offer(new BabyShark(ny, nx, cur.distance + 1));
                    visited[ny][nx] = true;
                }
            }

            if (!eatCheck) break;

            if (eat == size) {
                size++;
                eat = 0;
            }
        }

        System.out.println(time);
    }
}
package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_14502_Gold4_BFS {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int H, W;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st1.nextToken());
        W = Integer.parseInt(st1.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        wallDfs(0);

        System.out.println(result);
    }

    // 아무데나 벽 세워보기
    private static void wallDfs(int count) {
        // 벽이 3개 되면 바이러스 퍼뜨리고, 퍼진 지도를 기반으로 안전지역 구해서 최댓값과 비겨하기
        if (count == 3) {
            int safeAreaCount = proceedVirusAndCountSafeArea();
            if (safeAreaCount > result) { // 안전 구역 최댓값 갱신
                result = safeAreaCount;
            }
            return;
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    wallDfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int countSafeArea(int[][] map) {
        int safeAreaCount = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    safeAreaCount++;
                }
            }
        }

        return safeAreaCount;
    }

    private static int proceedVirusAndCountSafeArea() {
        // 원본 훼손을 방지하기 위해 복사된 지도
        int[][] copiedMap = new int[H][W];
        for (int i = 0; i < H; i++) {
            copiedMap[i] = map[i].clone();
        }
        visited = new boolean[H][W];

        // 곧곧에 흩어져 있는 바이러스들을 조사해서 큐에 넣는 작업
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (copiedMap[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];
            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (nextX >= 0 && nextY >= 0 && nextX < W && nextY < H && !visited[nextY][nextX]) {
                    // 빈 칸으로 바이러스가 침투
                    if (copiedMap[nextY][nextX] == 0) {
                        copiedMap[nextY][nextX] = 2;
                        visited[nextY][nextX] = true;
                        queue.offer(new int[]{nextY, nextX});
                    }
                }
            }
        }

        return countSafeArea(copiedMap);
    }
}

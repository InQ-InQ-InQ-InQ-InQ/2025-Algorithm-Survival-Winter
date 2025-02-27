package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_13549_Gold5_BFS {

    static int[] map = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // logic
        bfs(start);
        if (start == end) {
            System.out.println(0);
        } else {
            System.out.println(map[end]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            Move[] moves = new Move[3];
            moves[0] = new Move(cur * 2, 0);
            moves[1] = new Move(cur - 1, 1);
            moves[2] = new Move(cur + 1, 1);

            for (int i = 0; i < moves.length; i++) {
                Move move = moves[i];
                int next = move.next;

                if (next >= 0 && next <= 100000) {
                    // 내가 방문한 곳 중에 최소 이동거리인 곳은 +1을 하지 않고 스킵한다.
                    // 순간이동일 경우 이동해도 시간이 늘지 않기 때문에, 현재 위치보다 작거나 같으면 최소 이동거리인 것으로 판단한다. (move.time)
                    if (map[next] <= map[cur] + move.time && visited[next]) {
                        continue;
                    }

                    map[next] = map[cur] + move.time;
                    visited[next] = true;
                    if (next == end) {
                        break;
                    }
                    queue.offer(next);
                }
            }
        }
    }

    static class Move {

        int next;
        int time;

        public Move(int next, int time) {
            this.next = next;
            this.time = time;
        }
    }
}

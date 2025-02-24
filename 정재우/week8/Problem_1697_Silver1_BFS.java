package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_1697_Silver1_BFS {
    static int[] map;
    static int N, K;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[100001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // logic
        bfs(N);

        // print
        if (N == K) {
            System.out.println(0);
        } else {
            System.out.println(map[K]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {
            Integer cur = queue.poll();
            int[] next = new int[3];
            next[0] = cur - 1;
            next[1] = cur + 1;
            next[2] = cur * 2;

            for (int i = 0; i < next.length; i++) {
                if (next[i] >= 0 && next[i] <= 100000) {
                    if (map[next[i]] != 0 && map[next[i]] <= map[cur] + 1) {
                        continue;
                    }
                    map[next[i]] = map[cur] + 1;
                    if (next[i] == K) {
                        break;
                    }
                    queue.offer(next[i]);
                }
            }
        }
    }
}

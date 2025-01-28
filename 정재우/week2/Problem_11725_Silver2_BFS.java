package week2;

import java.io.*;
import java.util.*;

public class Problem_11725_Silver2_BFS {
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        // logic
        bfs(1);

        for (int i = 1; i < N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            Integer current = queue.poll();

            for (Integer next : tree[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    parent[next - 1] = current;
                }
            }
        }
    }
}

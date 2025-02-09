package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_24479_Silver2_DFS {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] result;
    static int count;
    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        result = new int[N];

        for (int i = 1; i < M + 1; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // logic
        count = 1;
        dfs(R);

        for (int i : result) {
            System.out.println(i);
        }
    }

    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        result[v - 1] = count++;
        Collections.sort(graph[v]);
        for (Integer next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}

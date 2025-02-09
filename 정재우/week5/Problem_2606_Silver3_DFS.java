package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2606_Silver3_DFS {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int V, E;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // read
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        graph = new List[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        count = 0;
        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int start) {
        if (visited[start]) {
            return;
        }
        visited[start] = true;
        for (int adjacentV : graph[start]) {
            if (!visited[adjacentV]) {
                count++;
                dfs(adjacentV);
            }
        }
    }
}

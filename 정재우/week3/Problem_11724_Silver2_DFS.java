package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_11724_Silver2_DFS {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) { // 모든 노드를 돌면서 방문하지 않은 노드가 있을 시 count 증가
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x) { // 연결된 노드를 모두 방문하도록 함
        if (visited[x]) { // 인덱스가 점차 올라가면서, 이미 방문한 i - 1, i - 2 등의 노드들을 스킵하기 위한 로직
            return;
        }
        visited[x] = true;
        for (int adjacentVertex : graph[x]) {
            if (!visited[adjacentVertex]) {
                dfs(adjacentVertex);
            }
        }
    }
}

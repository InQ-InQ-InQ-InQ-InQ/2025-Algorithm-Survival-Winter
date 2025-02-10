package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_2644_Silver2_DFS {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, E;
    static int a, b;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // read
        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        E = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 개수 m
        for (int i = 1; i < E + 1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken()); // 부모
            int y = Integer.parseInt(st2.nextToken()); // 자식
            graph[x].add(y);
            graph[y].add(x);
        }

        // logic
        answer = -1;
        dfs(b, 0);

        System.out.println(answer);
    }

    private static void dfs(int v, int count) {
        if (v == a) {
            answer = count;
            return;
        }
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (Integer adjacentV : graph[v]) {
            if (!visited[adjacentV]) {
                dfs(adjacentV, count + 1); // depth가 깊어질수록 count가 증가됨
            }
        }
    }
}

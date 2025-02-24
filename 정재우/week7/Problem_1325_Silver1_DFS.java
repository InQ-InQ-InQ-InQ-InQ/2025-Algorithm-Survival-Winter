package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1325_Silver1_DFS {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, E;
    static int count;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // init
        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < E; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            graph[b].add(a);
        }

        // logic
        for (int i = 1; i < N + 1; i++) {
            count = 0;
            dfs(i);
            result[i] = count;
            visited = new boolean[N + 1];
        }

        int max = getMaxFromArray(result);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        count++;
        for (Integer nextV : graph[v]) {
            if (!visited[nextV]) {
                dfs(nextV);
            }
        }
    }

    private static int getMaxFromArray(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }
}

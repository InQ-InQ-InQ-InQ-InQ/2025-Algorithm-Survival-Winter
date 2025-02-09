import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node arg0) {
            return weight - arg0.weight;
        }
    }

    static int n, m, x;
    static ArrayList<ArrayList<Node>> graph, reverseGraph;
    static final int MAX_INT = Integer.MAX_VALUE;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        // 정점 개수로 시작점 잡기
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        // 간선 추가
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
            reverseGraph.get(end).add(new Node(start, weight));
        }

        int[] distanceArr = dijkstra(graph);
        int[] reverseDistanceArr = dijkstra(reverseGraph);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, distanceArr[i] + reverseDistanceArr[i]);
        }

        bw.write(ans + "\n");
        bw.flush();

    }

    static int[] dijkstra(ArrayList<ArrayList<Node>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, MAX_INT);
        // x까지 가는 거리를 구하는 것이기 때문임
        distance[x] = 0;

        while(!pq.isEmpty()) {
            Node temp = pq.poll();
            int cur = temp.end;

            if(!visited[cur]) {
                visited[cur] = true;

                for(Node node : graph.get(cur)){
                    if(!visited[node.end] && distance[node.end] > distance[cur] + node.weight) {
                        distance[node.end] = distance[cur] + node.weight;
                        pq.offer(new Node(node.end, distance[node.end]));
                    }
                }
            }

        }
        return distance;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}

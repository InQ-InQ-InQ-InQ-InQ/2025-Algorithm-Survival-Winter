package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_1068_Gold5_DFS {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        N = Integer.parseInt(br.readLine());
        graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N];

        // 노드 간의 관계 넣기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(st.nextToken());
            if (c == -1) {
                root = i;
            } else { // c가 부모 노드이므로, 부모에 자식인 i를 추가
                graph[c].add(i);
            }
        }

        // 삭제할 노드 번호 입력
        int deletedNode = Integer.parseInt(br.readLine());

        // logic
        count = 0;
        deleteNode(deletedNode);
        dfs(root);

        // print
        if (deletedNode == root) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }

    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        // 리프 노드인지 확인 -> graph[v].size()가 0인지 확인
        if (graph[v].isEmpty()) {
            count++;
        }

        // 다음 노드 탐색
        for (Integer nextV : graph[v]) {
            // 방문하지 않은 곳이거나, graph[nextV].get(0)이 -1이 아니어야 함
            if (!visited[nextV]) {
                dfs(nextV);
            }
        }
    }

    // i와, i에 딸려있는 graph[i]의 원소들을 모두 제거해야 함
    // 이미 배열에 할당된 인덱스를 지울 수 없으므로, 임의로 graph[i].get(0)을 -1로 만들면서 모두 제거되었음을 시사해볼 예정
    private static void deleteNode(int i) {
        for (int j = 0; j < graph.length; j++) {
            if (graph[j].contains(i)) {
                graph[j].remove(Integer.valueOf(i));
            }
        }
    }
}

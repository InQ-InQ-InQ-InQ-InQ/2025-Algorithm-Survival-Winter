import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    // 풀이용 변수
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] edgeCount;

    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edgeCount = new int[n + 1];
        graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            edgeCount[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            if(edgeCount[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp).append(" ");
            ArrayList<Integer> neighbors = graph.get(temp);
            for(int i = 0; i < neighbors.size(); i++){
                edgeCount[neighbors.get(i)]--;
                if(edgeCount[neighbors.get(i)] == 0){
                    queue.offer(neighbors.get(i));
                }
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
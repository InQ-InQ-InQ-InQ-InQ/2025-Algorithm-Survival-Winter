import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static PriorityQueue<Long> priorityQueue;
    static int n, m;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        priorityQueue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            priorityQueue.offer(Long.parseLong(st.nextToken()));
        }

        for(int i = 1; i <= m; i++) {
            Long a = priorityQueue.poll();
            Long b = priorityQueue.poll();

            Long temp = a + b;

            priorityQueue.add(temp);
            priorityQueue.add(temp);
        }

        Long sum = 0L;

        while(!priorityQueue.isEmpty()) {
            sum += priorityQueue.poll();
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}

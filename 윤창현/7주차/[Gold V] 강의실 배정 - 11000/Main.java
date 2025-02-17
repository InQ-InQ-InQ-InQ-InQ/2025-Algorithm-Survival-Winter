import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    // 풀이용 변수
    static class Time{
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int n;
    static Time[] times;


    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());
        times = new Time[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] =  new Time(start, end);
        }

        Arrays.sort(times, (o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);

        PriorityQueue<Integer> endTimePQ = new PriorityQueue<>();

        endTimePQ.add(times[0].end);

        for(int i = 1; i < n; i++) {
            Time time = times[i];

            if(endTimePQ.peek() <= time.start) {
                endTimePQ.poll();
            }

            endTimePQ.add(time.end);
        }

        bw.write(endTimePQ.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
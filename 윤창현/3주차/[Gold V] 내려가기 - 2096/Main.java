import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 지워도 되는 변수
    static int n;
    static int[] maxDP, minDP;
    // 문제 풀이 함수
    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());
        maxDP = new int[3];
        minDP = new int[3];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] input = new int[3];
            for(int j = 0; j < 3; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            if(i == 0){
                maxDP[0] = minDP[0] = input[0];
                maxDP[1] = minDP[1] = input[1];
                maxDP[2] = minDP[2] = input[2];
            }else {
                int beforeMaxX0 = maxDP[0], beforeMaxX2 = maxDP[2];
                maxDP[0] = Math.max(maxDP[0], maxDP[1]) + input[0];
                maxDP[2] = Math.max(maxDP[1], maxDP[2]) + input[2];
                maxDP[1] = Math.max(beforeMaxX0, Math.max(maxDP[1], beforeMaxX2)) + input[1];

                int beforeMinX0 = minDP[0], beforeMinX2 = minDP[2];
                minDP[0] = Math.min(minDP[0], minDP[1]) + input[0];
                minDP[2] = Math.min(minDP[1], minDP[2]) + input[2];
                minDP[1] = Math.min(beforeMinX0, Math.min(minDP[1], beforeMinX2)) + input[1];
            }
        }

        System.out.println(Arrays.stream(maxDP).max().getAsInt() + " " + Arrays.stream(minDP).min().getAsInt());
    }



    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}

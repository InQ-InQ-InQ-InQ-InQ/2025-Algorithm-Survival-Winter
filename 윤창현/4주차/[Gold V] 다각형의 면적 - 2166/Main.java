import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    // 풀이용 변수
    static double result;
    static int[][] matrix;
    static int n;

    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());

        matrix = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        double sum = 0;

        for(int i = 0; i < n; i++){
            sum += (double) matrix[i][0] * matrix[(i + 1) % n][1];
            sum -= (double) matrix[i][1] * matrix[(i + 1) % n][0];
        }

        result = Math.abs(sum) * 0.5;
        System.out.printf("%.1f", result);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
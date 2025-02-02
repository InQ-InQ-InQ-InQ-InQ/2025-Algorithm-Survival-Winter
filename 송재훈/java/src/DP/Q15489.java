package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q15489 {

    private static final int[][] memo = new int[32][32];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= 30; i++) {
            for(int j = 1; j <= i; j++) {
                if(i == j || j == 1) memo[i][j] = 1;
                else {
                    memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
                }
            }
        }
        bw.write(String.valueOf(sum(R, C, W)));
        bw.flush();
    }

    private static int sum(int R, int C, int W) {
        int sum = 0;
        for(int i = 0; i < W; i++) {
            for(int j = 0; j <= i; j++) {
                sum += memo[R + i][C + j];
            }
        }
        return sum;
    }
}

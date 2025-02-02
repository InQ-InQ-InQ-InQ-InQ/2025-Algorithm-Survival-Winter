package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q13699 {

    private static final long[] memo = new long[37];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        memo[0] = 1;
        memo[1] = 1;
        bw.write(String.valueOf(dp(Integer.parseInt(input))));
        bw.flush();
    }

    private static long dp(int n) {

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                memo[i] += memo[j] * memo[i - 1 - j];
            }
        }

        return memo[n];
    }
}

package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q17626 {

    private static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);

        memo[0] = 0;

        bw.write(String.valueOf(dp(n)));
        bw.flush();

    }

    private static int dp(int n) {
        for(int i = 1; i * i <= n; i++) {
            for(int j = i * i; j <= n; j++) {
                // dp 문제는 이미 있던걸 활용하는 것이므로, 제곱수에서 n까지 남은 수를 조진다.
                memo[j] = Math.min(memo[j], memo[j - i * i] + 1);
            }
        }
        return memo[n];
    }

}

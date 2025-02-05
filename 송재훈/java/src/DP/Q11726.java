package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q11726 {

    private static final int[] memo = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo[1] = 1;
        memo[2] = 2;

        bw.write(String.valueOf(dp(n)));
        bw.flush();
    }

    private static int dp(int n) {
        for(int i = 3; i <= n; i++) {
            memo[i] = memo[i - 2] % 10007 + memo[i - 1] % 10007;
        }
        return memo[n] % 10007;
    }
}

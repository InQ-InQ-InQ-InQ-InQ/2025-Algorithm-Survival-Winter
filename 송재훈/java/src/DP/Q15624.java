package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q15624 {

    private static final long[] memo = new long[1000002];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] % 1000000007 + memo[i - 2] % 1000000007;
        }

        bw.write(String.valueOf(memo[n] % 1000000007));
        bw.flush();

    }
}

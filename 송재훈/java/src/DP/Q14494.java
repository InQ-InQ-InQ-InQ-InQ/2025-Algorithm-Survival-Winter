package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14494 {

    private static long[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        memo = new long[n + 1][m + 1];
        
        long result = dp(n, m);
        bw.write(String.valueOf(result % 1000000007));
        bw.flush();
    }

    public static long dp(int n, int m) {
        memo[0][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                memo[i][j] =
                    (memo[i - 1][j] % 1000000007) + (memo[i][j - 1] % 1000000007) + (memo[i - 1][j - 1] % 1000000007);
            }
        }

        return memo[n][m];
    }


}

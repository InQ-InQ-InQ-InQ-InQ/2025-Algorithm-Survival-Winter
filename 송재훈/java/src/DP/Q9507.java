package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q9507 {
    private static final long[] koong = new long[69];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int s = Integer.parseInt(br.readLine());
            bw.write(dp(s) + "\n");
        }
        bw.flush();
    }

    public static long dp(int n) {
        if(n < 2) koong[n] = 1;
        if(n == 2) koong[n] = 2;
        if(n == 3) koong[n] = 4;

        for(int i = 4; i <= n; i++) {
            koong[i] = koong[i - 1] + koong[i - 2] + koong[i - 3] + koong[i - 4];
        }

        return koong[n];
    }
}

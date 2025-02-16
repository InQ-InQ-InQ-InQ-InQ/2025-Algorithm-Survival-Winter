package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q9657 {

    private static String[] memo = new String[1002];
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        memo[1] = "SK";
        memo[2] = "CY";
        memo[3] = "SK";
        memo[4] = "SK";

        bw.write(dp(n));
        bw.flush();
    }

    private static String dp(int n) {
        for(int i = 5; i <= n; i++) {
            if(memo[i - 1].equals("CY") || memo[i - 3].equals("CY") || memo[i - 4].equals("CY")) {
                memo[i] = "SK";
            } else {
                memo[i] = "CY";
            }
        }
        return memo[n];
    }

}

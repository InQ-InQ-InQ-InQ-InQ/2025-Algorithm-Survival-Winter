package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14501 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] memo = new int[N + 1];
        int[] day = new int [N];
        int[] profit = new int [N];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            day[i] = a;
            profit[i] = b;
        }

        for(int i = 0; i < N; i++) {
            if(i + day[i] <= N) {
                memo[i + day[i]] = Math.max(memo[i + day[i]], memo[i] + profit[i]);
            }
            memo[i + 1] = Math.max(memo[i + 1], memo[i]);
        }

        bw.write(String.valueOf(memo[N]));
        bw.flush();
    }
}

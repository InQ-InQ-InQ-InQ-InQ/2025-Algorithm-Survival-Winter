package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1535 {

    private final static int[] memo = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> lost = new ArrayList<>();
        List<Integer> add = new ArrayList<>();

        String health = br.readLine();
        String happy = br.readLine();

        StringTokenizer stForHealth = new StringTokenizer(health);
        StringTokenizer stForHappy = new StringTokenizer(happy);
        for(int i = 0; i < N; i++) {
            lost.add(Integer.parseInt(stForHealth.nextToken()));
            add.add(Integer.parseInt(stForHappy.nextToken()));
        }

        for(int i = 0; i < N; i++) {
            for(int j = 99; j >= lost.get(i); j--) {
                memo[j] = Math.max(memo[j], memo[j - lost.get(i)] + add.get(i));
            }
        }

        bw.write(String.valueOf(memo[99]));
        bw.flush();
    }
}

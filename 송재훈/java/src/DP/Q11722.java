package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q11722 {

    private final static int[] memo = new int[1002];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(list.get(i) < list.get(j)) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
            result = Math.max(result, memo[i]);
        }

        bw.write(String.valueOf(result + 1));
        bw.flush();
    }
}

package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q19941 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        StringTokenizer st = new StringTokenizer(num);
        int N = Integer.parseInt(st.nextToken()); // 식탁의 길이
        int K = Integer.parseInt(st.nextToken()); // 가능한 거리
        String input = br.readLine();

        boolean[] visited = new boolean[N];

        int count = 0;
        for(int i = 0; i < N; i++) {
            if(input.charAt(i) == 'P') {
                for(int j = i - K; j < N && j <= i + K; j++) {
                    if(j >= 0 && !visited[j] && input.charAt(j) == 'H') {
                        count++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }

        bw.write("" + count);
        bw.flush();

    }
}

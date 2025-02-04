package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5525_Silver1_String {
    static int N;
    static int M;
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int pLength = 2 * N + 1;
        String P = "IO".repeat(N) + "I";

        M = Integer.parseInt(br.readLine());
        S = br.readLine();

        // logic
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (i + pLength > M) {
                break;
            }

            boolean isPExist = true;
            for (int j = i; j < i + pLength; j++) { // S의 i ~ i+pLength 가 P와 일치하는지 비교
                if (S.charAt(j) != P.charAt(j - i)) {
                    isPExist = false;
                    break;
                }
            }
            if (isPExist) {
                count++;
            }
        }

        System.out.println(count);
    }
}

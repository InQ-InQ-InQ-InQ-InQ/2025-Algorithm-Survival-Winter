package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1120 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        StringTokenizer st = new StringTokenizer(S);
        String X = st.nextToken();
        String Y = st.nextToken();
        int min = X.length();

        int idx = 0;
        while (idx <= Y.length() - X.length()) {
            int check = 0;
            for (int j = 0; j < X.length(); j++) {
                if (X.charAt(j) != Y.charAt(j + idx)) {
                    check++;
                }
            }
            if (check < min) {
                min = check;
            }
            idx++;
        }

        bw.write(String.valueOf(min));
        bw.flush();
    }
}

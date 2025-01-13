package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Q11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < S.length(); i++) {
            for(int j = i + 1; j <= S.length(); j++) {
                String substring = S.substring(i, j);
                set.add(substring);
            }
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
    }
}

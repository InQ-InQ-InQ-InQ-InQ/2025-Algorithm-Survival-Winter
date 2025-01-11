package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Q11656 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        List<String> list = new ArrayList<>();

        for(int i = 0; i < S.length(); i++) {
            list.add(S.substring(i));
        }

        list.sort(String::compareTo);

        for(String s : list) {
            bw.write(s + "\n");
        }

        bw.flush();
    }
}

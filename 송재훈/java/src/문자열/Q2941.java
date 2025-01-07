package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class Q2941 {

    private static final List<String> alphabetList = List.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        for(String s : alphabetList) {
            if(input.contains(s)) {
                input = input.replace(s, "O");
            }
        }

        bw.write(String.valueOf(input.length()));
        bw.flush();
    }
}

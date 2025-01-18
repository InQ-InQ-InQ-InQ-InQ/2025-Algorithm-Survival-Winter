package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Q9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String firstPattern = "";
        String lastPattern = "";
        for(int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == '*') {
                firstPattern = pattern.substring(0, i);
                lastPattern = pattern.substring(i + 1);
                break;
            }
        }

        List<String> files = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String file = br.readLine();
            files.add(file);
        }

        for(int i = 0; i < N; i++) {
            String file = files.get(i);
            try {
                String fileFirstPattern = file.substring(0, firstPattern.length());
                String fileLastPattern = file.substring(file.length() - lastPattern.length());
                if((fileFirstPattern.equals(firstPattern)) && (fileLastPattern.equals(lastPattern))) {
                    if(firstPattern.length() + lastPattern.length() > file.length()) {
                        bw.write("NE" + "\n");
                        continue;
                    }
                    bw.write("DA" + "\n");
                } else {
                    bw.write("NE" + "\n");
                }
            } catch (Exception e) {
                bw.write("NE" + "\n");
            }
        }

        bw.flush();
    }
}

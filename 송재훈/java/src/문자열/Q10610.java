package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q10610 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        List<Integer> list = new ArrayList<>();
        int zeroCount = 0;

        for(int i = 0; i < N.length(); i++){
            if(N.charAt(i) == '0'){
                zeroCount++;
            }
        }

        StringBuilder replace = new StringBuilder(N.replace("0", ""));
        int sum = 0;
        for(int i = 0; i < replace.length(); i++){
            sum += Integer.parseInt(String.valueOf(replace.charAt(i)));
        }
        if(sum % 3 != 0 || zeroCount == 0) {
            bw.write("-1");
        } else {
            for(int i = 0; i < zeroCount; i++){
                replace.append("0");
            }
            String result = replace.toString();
            List<String> results = List.of(result.split(""));
            List<String> sortedList = results.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
            StringBuilder sortedString = new StringBuilder();
            for(String s : sortedList){
                sortedString.append(s);
            }
            bw.write(sortedString.toString());
        }

        bw.flush();
    }

}

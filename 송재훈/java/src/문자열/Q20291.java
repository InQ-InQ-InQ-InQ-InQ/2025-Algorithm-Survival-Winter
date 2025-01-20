package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q20291 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String file = br.readLine();
            String[] split = file.split("\\.");
            String extension = split[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        List<String> collect = map.keySet().stream()
            .sorted(String::compareTo)
            .collect(Collectors.toList());

        for(String s : collect) {
            bw.write(s + " ");
            bw.write(map.get(s) + "\n");
        }

        bw.flush();
    }
}

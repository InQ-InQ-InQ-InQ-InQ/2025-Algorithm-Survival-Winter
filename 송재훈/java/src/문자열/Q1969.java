package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1969 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> dnaList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String dna = br.readLine();
            dnaList.add(dna);
        }

        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                String dna = dnaList.get(j);
                map.put(dna.charAt(i), map.getOrDefault(dna.charAt(i), 0) + 1);
            }
            Set<Character> keys = map.keySet();
            int max = map.get(keys.iterator().next());
            String maxKey = String.valueOf(keys.iterator().next());
            for(Character key : keys) {
                if(map.get(key) > max) {
                    max = map.get(key);
                    maxKey = String.valueOf(key);
                } else if (map.get(key) == max) {
                    if (String.valueOf(key).compareTo(maxKey) < 0) {
                        max = map.get(key);
                        maxKey = String.valueOf(key);
                    }
                }
            }
            sb.append(maxKey);
            for(int k = 0; k < N; k++) {
                if(!String.valueOf(dnaList.get(k).charAt(i)).equals(maxKey)) {
                    sum++;
                }
            }
            map.clear();
        }
        String sumResult = String.valueOf(sum);
        bw.write(sb + " \n");
        bw.write(sumResult);

        bw.flush();
    }
}

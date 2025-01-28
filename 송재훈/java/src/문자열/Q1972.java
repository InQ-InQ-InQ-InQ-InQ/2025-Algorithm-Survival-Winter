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
import java.util.stream.Collectors;

public class Q1972 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputs = new ArrayList<>();
        String input = br.readLine();
        inputs.add(input);
        Map<String, Boolean> result = new HashMap<>();
        while(true) {
            input = br.readLine();
            if(input.equals("*")) {
                break;
            }
            inputs.add(input);
        }

        for(int i = 0; i < inputs.size(); i++) {
            String word = inputs.get(i);
            for(int j = 1; j < word.length(); j++) {
                boolean isSurprising = true;
                List<String> temp = new ArrayList<>();
                for(int k = 0; k + j < word.length(); k++) {
                    String s = word.charAt(k) + "" + word.charAt(k + j);
                    if(temp.contains(s)) {
                        result.put(word, false);
                        isSurprising = false;
                        break;
                    } else {
                        temp.add(s);
                    }
                }
                if(!isSurprising) {
                    break;
                }
            }
        }

        List<String> surprises = inputs.stream()
            .filter(s -> !result.containsKey(s))
            .collect(Collectors.toList());

        List<String> notSurprises = result.keySet().stream()
            .collect(Collectors.toList());


        for(int i = 0; i < inputs.size(); i++) {
            String word = inputs.get(i);
            if(surprises.contains(word)) {
                bw.write(word + " is surprising." + "\n");
            }
            if(notSurprises.contains(word)) {
                bw.write(word + " is NOT surprising." + "\n");
            }
        }
        bw.flush();
    }
}

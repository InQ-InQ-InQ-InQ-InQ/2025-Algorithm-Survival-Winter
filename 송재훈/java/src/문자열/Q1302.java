package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q1302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Map<String, Integer> sellMap = new HashMap<>();

        int N = Integer.parseInt(input);

        for(int i = 0; i < N; i++) {
            String book = br.readLine();
            sellMap.put(book, sellMap.getOrDefault(book, 0) + 1);
        }

        List<Integer> values = sellMap.values().stream()
            .collect(Collectors.toList());

        int maxValue = values.get(0);
        for(int value : values) {
            if(value >= maxValue) {
                maxValue = value;
            }
        }

        List<String> bookList = sellMap.keySet().stream()
            .collect(Collectors.toList());

        List<String> bestBooks = new ArrayList<>();
        for(String book : bookList) {
            if(sellMap.get(book) == maxValue) {
                bestBooks.add(book);
            }
        }

        bestBooks.sort(String::compareTo);

        System.out.println(bestBooks.get(0));
    }
}

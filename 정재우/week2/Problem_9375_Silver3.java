package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_9375_Silver3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcaseCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcaseCount; i++) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> cloth = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String clothName = st.nextToken();
                String clothType = st.nextToken();

                cloth.put(clothType, cloth.getOrDefault(clothType, 0) + 1);
            }

            int clothNameCount = cloth.keySet().stream()
                    .mapToInt(cloth::get)
                    .sum();
            int clothTypeCount = cloth.values().size();

            int sum = 1;
            for (int value : cloth.values()) {
                sum *= combination(value + 1, 1);
            }
            System.out.println(sum - 1);
        }
    }

    public static int combination(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}

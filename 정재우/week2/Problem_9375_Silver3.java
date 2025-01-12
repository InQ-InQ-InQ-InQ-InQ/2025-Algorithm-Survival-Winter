package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_9375_Silver3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T -- > 0) {
            HashMap<String, Integer> hm = new HashMap<>();
            int N = Integer.parseInt(br.readLine());

            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String kind = st.nextToken();

                if (hm.containsKey(kind)) {
                    hm.put(kind, hm.get(kind) + 1);
                }
                else {
                    hm.put(kind, 1);
                }
            }

            int result = 1;
            for (int val : hm.values()) {
                result *= (val + 1);
            }
            sb.append(result - 1).append('\n');
        }
        System.out.println(sb);
    }
}

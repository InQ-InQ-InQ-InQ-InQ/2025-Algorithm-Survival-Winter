package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_11725_Silver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        for (int i = 2; i <= N; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < tree[i].size(); j++) {
                System.out.print(tree[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}

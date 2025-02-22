package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q1448 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;
        for(int i = N - 1; i >= 2; i--) {
            if(arr[i] + arr[i - 1] > arr[i - 2]
                && arr[i - 1] + arr[i - 2] > arr[i]
                && arr[i - 2] + arr[i] > arr[i - 1])
            {
                sum = arr[i] + arr[i - 1] + arr[i - 2];
                break;
            }

        }

        if(sum == 0) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(sum));
        }
        bw.flush();

    }
}

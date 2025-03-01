package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q2697 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] arr = new String[T];

        for(int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        for(int i = 0; i < T; i++) {
            int index = -1;
            String temp = arr[i];
            String[] tempArr = temp.split("");
            for(int j = temp.length() - 2; j >= 0; j--) {
                int min = Integer.MAX_VALUE;
                int swapIndex = -1;
                for(int k = j + 1; k < tempArr.length; k++) {
                    int a = Integer.parseInt(tempArr[j]);
                    int b = Integer.parseInt(tempArr[k]);
                    if(a < b && b < min) {
                        min = b;
                        swapIndex = k;
                    }
                }
                if(swapIndex != -1) {
                    String tempString = tempArr[j];
                    tempArr[j] = tempArr[swapIndex];
                    tempArr[swapIndex] = tempString;
                    index = j;
                    break;
                }
            }
            if(index == -1) {
                bw.write("BIGGEST\n");
                continue;
            }
            Arrays.sort(tempArr, index + 1, tempArr.length);
            for(String s : tempArr) {
                bw.write(s);
            }
            bw.write("\n");
        }
        bw.flush();
    }
}

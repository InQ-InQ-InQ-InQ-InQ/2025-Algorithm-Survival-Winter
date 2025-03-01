package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q20413 {
    private static int B = 0;
    private static int S = 0;
    private static int G = 0;
    private static int P = 0;
    private static int D = 0;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String range = br.readLine();
        String degree = br.readLine();
        String[] rangeArr = range.split(" ");

        B = Integer.parseInt(rangeArr[0]) - 1;
        S = Integer.parseInt(rangeArr[1]) - 1;
        G = Integer.parseInt(rangeArr[2]) - 1;
        P = Integer.parseInt(rangeArr[3]) - 1;
        D = Integer.parseInt(rangeArr[3]);

        String[] degreeArr =  degree.split("");
        int[] spendArr = new int[N];
        for(int i = 0; i < N; i++) {
            if(i == 0 || degreeArr[i].equals("D")) {
                moneySpend(degreeArr, spendArr, i);
            } else {
                moneySpend(degreeArr, spendArr, i);
                spendArr[i] -= spendArr[i - 1];
            }
        }

        int result = 0;
        for(int i : spendArr) {
            result += i;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    private static void moneySpend(String[] degreeArr, int[] spendArr, int i) {
        switch(degreeArr[i]) {
            case "B": spendArr[i] = B; break;
            case "S": spendArr[i] = S; break;
            case "G": spendArr[i] = G; break;
            case "P": spendArr[i] = P; break;
            case "D": spendArr[i] = D;
        }
    }
}

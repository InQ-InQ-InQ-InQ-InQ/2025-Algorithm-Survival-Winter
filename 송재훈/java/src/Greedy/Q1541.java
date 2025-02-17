package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] maths = new String[25];
        int mathIndex = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-'){
                maths[mathIndex++] = String.valueOf(input.charAt(i));
            }
        }

        String[] split = input.split("[+-]");
        int[] nums = new int[split.length];
        for(int i = 0; i < split.length; i++){
            nums[i] = Integer.parseInt(split[i]);
        }

        for(int i = 0; i < mathIndex - 1; i++) {
            if(maths[i].equals("-") && maths[i + 1].equals("+")) {
                maths[i + 1] = "-";
            }
        }

        int result = nums[0];
        for(int i = 0; i < mathIndex; i++) {
            if(maths[i].equals("+")) {
                result += nums[i + 1];
            } else if (maths[i].equals("-")) {
                result -= nums[i + 1];
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}

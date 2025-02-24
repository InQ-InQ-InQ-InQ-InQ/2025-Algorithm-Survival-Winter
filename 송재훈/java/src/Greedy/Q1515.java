package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1515 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

//        String last = 0 + String.valueOf(input.charAt(0));
//        int check = 0;
//
//        for(int i = 0; i < input.length() - 1; i++) {
//            String prev = last;
//            String next = String.valueOf(input.charAt(i + 1));
//            if(Integer.parseInt(prev) < Integer.parseInt(check + next)) {
//                if((Integer.parseInt(check + next) < Integer.parseInt(next + check))) {
//                    last = check + next;
//                } else {
//                    if(Integer.parseInt(next + check) <= Integer.parseInt(prev)) {
//                        last = check + next;
//                    } else {
//                        last = next + check;
//                    }
//                }
//            } else {
//                check++;
//            }
//        }
//        bw.write(String.valueOf(Integer.parseInt(last)));
//        bw.flush();

        int result = 0;
        int index = 0;

        while(true) {
            result++;
            String num = String.valueOf(result);
            for(int i = 0; i < num.length(); i++) {
                if(num.charAt(i) == input.charAt(index)) {
                    index++;
                }
                if(index == input.length()) {
                    bw.write(String.valueOf(result));
                    bw.flush();
                    System.exit(0);
                }
            }
        }

    }
}

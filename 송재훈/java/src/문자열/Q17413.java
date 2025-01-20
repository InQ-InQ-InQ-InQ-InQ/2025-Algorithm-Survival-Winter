package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Q17413 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for(int i=0;i<S.length();i++){
            if (S.charAt(i) == '<') {
               flag = true;
               while(!stack.isEmpty()){
                   sb.append(stack.pop());
               }
               sb.append(S.charAt(i));
            } else if (S.charAt(i) == '>') {
                flag = false;
                sb.append(S.charAt(i));
            } else if (flag) {
                sb.append(S.charAt(i));
            } else {
                if (S.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(S.charAt(i));
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

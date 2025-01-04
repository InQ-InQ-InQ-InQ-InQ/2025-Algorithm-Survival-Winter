package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int zeroCount = 0;
        int oneCount = 0;

        char prev = '0';

        if(input.charAt(0) == '0') {
            zeroCount++;
        } else {
            oneCount++;
            prev = '1';
        }

        for(int i = 1; i < input.length(); i++) {
            if(prev != input.charAt(i)) {
                if(input.charAt(i) == '0') {
                    zeroCount++;
                    prev = '0';
                } else {
                    oneCount++;
                    prev = '1';
                }
            }
        }
        if(zeroCount >= oneCount) {
            System.out.println(oneCount);
        } else{
            System.out.println(zeroCount);
        }
    }
}

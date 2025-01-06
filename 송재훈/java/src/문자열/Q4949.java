package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Q4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String input = br.readLine();
            if(input.equals(".")){
                break;
            }
            if(validateString(input)) {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }

    private static boolean validateString(String input) {
        String[] array = input.split("");
        List<String> list = Arrays.asList(array);
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < list.size(); i++){

            if(list.get(i).equals("(") || list.get(i).equals("[")) {
                stack.push(list.get(i));
            }

            if(list.get(i).equals(")")) {
                if(stack.isEmpty() || !stack.pop().equals("(")){
                    return false;
                }
            }

            if(list.get(i).equals("]")) {
                if(stack.isEmpty() || !stack.pop().equals("[")) {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}

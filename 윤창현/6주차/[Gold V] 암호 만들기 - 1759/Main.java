import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int l, c;
    static char[] chars, codes;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        chars = new char[c];
        codes = new char[l];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < c; i++){
            chars[i] = st.nextToken().charAt(0);
        }

        // 암호는 서로 다른 L개의 알파벳 소문자들로 구성
        // 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성

        Arrays.sort(chars);

        makeCode(0, 0);
    }

    static void makeCode(int x, int index){
        // 종료 조건
        // 만들어진 코드의 길이가 내가 원하는 코드의 길이인 경우
        if(index == l){
            if(checkCode()){
                System.out.println(codes);
            }
            return;
        }

        // 코트 만들기
        for(int i = x; i < c; i++){
            codes[index] = chars[i];
            makeCode(i + 1, index + 1);
        }
    }

    // 암호 자음 여부 체크
    static boolean checkCode(){
        int m = 0;
        int j = 0;

        for(char x : codes){
            if ("aeiou".indexOf(x) >= 0) {
                m++;
            } else {
                j++;
            }
        }

        if(m >= 1 && j >= 2){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}

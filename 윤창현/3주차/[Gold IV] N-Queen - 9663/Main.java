import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    // 풀이용 변수
    static int n;
    static int[] arr;   // 퀸을 놓을 배열
    static int count = 0;

    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        nQueen(0);
        System.out.println(count);
    }

    /**
     * 체스판에 퀸을 두는 재귀함수
     * @param level 현재 말을 두는 행
     */
    static void nQueen(int level){
        // 체스판에 말을 다 놓은 경우
        if(level == n){
            count++;
            return;
        }

        // 아직 다 놓지 못한 경우
        for(int i = 0; i < n; i++){
            // 일단 말을 둔 다음
            arr[level] = i;

            // 둘 수 있는 칸인지 확인하고 재귀함수?
            if(possibleQueen(level)){
                nQueen(level + 1);
            }
        }
    }

    /**
     * 해당 칸에 퀸을 둘 수 있는지 판단한다.
     * @param   col 체스판의 행
     * @return  퀸을 둘 수 있는지 여부
     */
    static boolean possibleQueen(int col){
        for(int i = 0; i < col; i++){
            // 무엇을 잘라내야 하는지 생각한다

            // 먼저 같은 줄에 말이 놓인 경우
            if(arr[col] == arr[i]){
                return false;
            }

            // 대각선 상에 말이 놓인 경우
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
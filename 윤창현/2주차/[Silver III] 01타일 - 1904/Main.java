import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 지워도 되는 변수
    static int n;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new Integer[1000001];

        dp[1] = 1;
        dp[2] = 2;

        System.out.println(tile(n));
    }

    static int tile(int n){
        if(dp[n] == null){
            dp[n] = (tile(n - 1) + tile(n - 2)) % 15746;
        }

        return dp[n];
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 지워도 되는 변수
    static int n;
    static int[][] dp = new int[100001][3];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for(int i = 2; i <= n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;    // 위에 아무 것도 없으면 아무곳에나 사자를 배치해도 됨

            // 만약 위에 사자가 있으면 그 칸만 피해서 배치하자.
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
    }


}
import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    // 지워도 되는 변수들
    static int result;
    static int[][] room;
    static int n;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        room = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        dfs(1,2,0);
        System.out.println(result);
    }

    static void dfs(int x, int y, int direction){
        // direction
        // 0 => 오른쪽 방향, 1 => 아래 방향, 2 => 대각선 방향
        if(x == n && y == n){
            result++;
            return;
        }

        // switch문 사용 후
        // 이동할 수 있는 방향이면 이동을 시키자
        switch (direction){
            // 가로 방향
            case 0: {
                // 대각선, 오른쪽 으로 이동 가능
                // 오른쪽으로 이동이 가능한 경우
                if(y + 1 <= n && room[x][y + 1] == 0){
                    dfs(x, y + 1, 0);
                }
                break;
            }
            // 세로 방향
            case 1: {
                // 아래 방향으로 이동 가능한 경우
                if(x + 1 <= n && room[x + 1][y] == 0){
                    dfs(x + 1, y, 1);
                }
                break;
            }
            // 대각선 방향
            case 2: {
                // 두 가지 경우로 이동 가능
                // 먼저 오른쪽 방향이 되는 경우
                if(y + 1 <= n && room[x][y + 1] == 0){
                    dfs(x, y + 1, 0);
                }
                // 아래 방향이 되는 경우
                if(x + 1 <= n && room[x + 1][y] == 0){
                    dfs(x + 1, y, 1);
                }
                break;
            }
        }

        // 대각선 방향의 이동은 공통된다.
        if(x + 1 <= n && y + 1 <= n && room[x + 1][y] == 0 && room[x + 1][y + 1] == 0 && room[x][y + 1] == 0){
            dfs(x + 1, y + 1, 2);
        }
    }
}
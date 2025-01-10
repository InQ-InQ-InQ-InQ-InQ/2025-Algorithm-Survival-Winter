import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 지워도 되는 변수
    static int n, k, l;
    static int[][] board;
    static Map<Integer, String> directionMap = new HashMap<>();
    static Queue<int[]> snakePosition = new LinkedList<>();

    // 0 -> 북, 1 -> 동, 2 -> 남, 3 -> 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    // 문제 풀이 함수
    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        board = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            directionMap.put(time, dir);
        }

        // 초기 위치 설정
        snakePosition.add(new int[] {1, 1});
        int x = 1;
        int y = 1;
        int dir = 1;
        int time = 0;


        while(true){

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            time++;

            // 종료조건 설정

            // 벽에 부딪히는 경우
            if(nx < 1 || ny < 1 || nx > n || ny > n){
                break;
            }

            // 자신의 몸에 부딪히는 경우 => 자신의 몸은 2로 표현함
            if(board[nx][ny] == 2){
                break;
            }

            // 사과가 없다면?
            // 몸을 늘리지 않는다. => 원래 있던 자리를 0으로 만든다
            if(board[nx][ny] == 0){
                int[] cur = snakePosition.poll();
                board[cur[0]][cur[1]] = 0;
            }

            // 현재 시간에 목을 꺾어야 하는 경우
            if(directionMap.containsKey(time)){
                String direction = directionMap.get(time);
                if (direction.equals("L"))
                    dir = dir-1 < 0 ? 3 : dir-1;
                if (direction.equals("D"))
                    dir = dir+1 > 3 ? 0 : dir+1;
            }

            // 그냥 이동하는 경우
            board[nx][ny] = 2;      // 머리가 위치함
            snakePosition.add(new int[] {nx, ny});  // 새로운 포지션
            // 현재 머리 위치 설정
            x = nx;
            y = ny;
        }

        System.out.println(time);
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}

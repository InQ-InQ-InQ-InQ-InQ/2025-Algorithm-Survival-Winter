import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Move{
        int d;
        int s;

        public Move(int d, int s) {
            this.d = d;
            this.s = s;
        }
    }

    static int n, m;
    static Queue<Position> cloud;
    static Queue<Move> moving;
    static int[][] map;
    static int cloudCount;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};


    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        moving = new LinkedList<>();
        cloud = new LinkedList<>();

        // 물의 양 저장
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 이동방향 저장
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            moving.add(new Move(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 초기 구름 생성 -> 비바라기 시전
        // (N, 1), (N, 2), (N-1, 1), (N-1, 2)
        cloud.add(new Position(n,1));
        cloud.add(new Position(n,2));
        cloud.add(new Position(n - 1,1));
        cloud.add(new Position(n - 1,2));
        cloudCount = 4;

        // 이제 구름 이동
        for(int i = 1; i <= m; i++){
            step1();
            step2();
            step3();
            step4();
        }

        // M번의 이동이 모두 끝난 후 바구니에 들어있는 물의 양의 합을 구해보자.
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    // step 1
    // 모든 구름이 di 방향으로 si칸 이동한다.
    static void step1(){
        Move move = moving.poll();
        int size = cloud.size();

        for(int i = 0; i < size; i++){
            Position p = cloud.poll();
            int x = (p.x + dx[move.d] * (move.s % n) + n - 1) % n + 1;
            int y = (p.y + dy[move.d] * (move.s % n) + n - 1) % n + 1;
            cloud.offer(new Position(x, y));
        }
    }

    // step 2
    // 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
    static void step2(){
        int size = cloud.size();
        for(int i = 0; i < size; i++){
            Position p = cloud.poll();
            map[p.x][p.y] += 1;
            cloud.offer(p);
        }
    }

    // step 3
    // 구름이 모두 사라진다.
    // 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다.
    // 물복사버그 마법을 사용하면,
    // 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
    static void step3(){
        int size = cloud.size();
        for(int i = 0; i < size; i++){
            Position p = cloud.poll();
            visited[p.x][p.y] = true;
            int count = 0;

            for(int j = 2; j <= 8; j += 2){ // 대각선 방향만 체크 (2, 4, 6, 8)
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];

                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                if(map[nx][ny] > 0) count++;
            }
            map[p.x][p.y] += count;
        }
    }

    // step 4
    // 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
    static void step4(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(map[i][j] >= 2 && !visited[i][j]){
                    map[i][j] -= 2;
                    cloud.offer(new Position(i, j));
                }
            }
        }

        // visited 배열 초기화
        for(int i = 1; i <= n; i++){
            Arrays.fill(visited[i], false);
        }
    }



    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}

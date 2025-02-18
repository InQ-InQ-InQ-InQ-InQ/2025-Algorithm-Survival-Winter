import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    // 풀이용 변수
    static int n;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][n];
        bfs();
    }

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int count = map[cur[0]][cur[1]];

            if(count == -1){
                System.out.println("HaruHaru");
                return;
            }

            for(int i = 0; i < 2; i++){
                int nx = cur[0] + dx[i] * count;
                int ny = cur[1] + dy[i] * count;

                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println("Hing");
    }


    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}
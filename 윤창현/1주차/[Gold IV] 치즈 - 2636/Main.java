import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    // 풀이용 변수
    static int n;
    static int m;
    static int[][] cheese;
    static boolean[][] visited;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    public static void main(String[] args) throws IOException {
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cheese = new int[n][m];

        int cheeseCount = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if(cheese[i][j] == 1){
                    cheeseCount++;
                }
            }
        }

        // bfs탐색 시작
        // 대신 치즈가 다 녹을 때까지 탐색을 수행한다.

        LinkedList<Integer> result = new LinkedList<>();
        int time = 1;
        while(true){
            int count = 0;
            visited = new boolean[n][m];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            visited[0][0] = true;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for(int i = 0; i < 4; i++){
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;

                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                        // 인접한 칸이 치즈이면 녹인다.
                        if (cheese[nx][ny] == 1) {
                            visited[nx][ny] = true;
                            cheese[nx][ny] = 0;
                            cheeseCount--;
                            count++;
                        }
                        // 인접한 칸이 치즈가 아니면 방문 처리만 한다.
                        else if(cheese[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }

            result.add(count);

            if(cheeseCount == 0){
                sb.append(time).append("\n");
                sb.append(result.get(result.size() - 1));

                System.out.println(sb);
                break;
            }
            time+= 1;
        }
    }

}
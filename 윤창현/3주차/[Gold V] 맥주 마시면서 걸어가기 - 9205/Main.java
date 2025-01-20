import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 지워도 되는 변수
    static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static Pos home, festival;
    static List<Pos> convinient;
    // 문제 풀이 함수
    static void solveProblem() throws IOException {
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            // 편의점의 개수
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            convinient = new ArrayList<>();
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                convinient.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            st = new StringTokenizer(br.readLine());
            festival = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            bfs();
        }
    }

    static void bfs(){
        Queue<Pos> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        // 집에서 출발
        queue.add(home);
        while(!queue.isEmpty()){
            Pos curPos = queue.poll();

            // 현재 위치에서 축제장이 1000이하면 종료
            if(Math.abs(curPos.x - festival.x) + Math.abs(curPos.y - festival.y) <= 1000){
                System.out.println("happy");
                return;
            }

            // 현재 위치에서 편의점 까지의 거리가 1000이하인 경우
            // 다음 위치로 이동이 가능함
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    Pos nowConvinient = convinient.get(i);
                    if(Math.abs(curPos.x - nowConvinient.x) + Math.abs(curPos.y - nowConvinient.y) <= 1000){
                        // 방문이 가능한 경우
                        visited[i] = true;
                        queue.add(nowConvinient);
                    }
                }
            }
        }

        System.out.println("sad");
        return;
    }

    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}

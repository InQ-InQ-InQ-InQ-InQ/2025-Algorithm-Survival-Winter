
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
    static int k;
    static int[][] food;
    static int[][] map;
    static List<Tree> treeList = new ArrayList<>();
    static Deque<Integer> deathTreeIndex = new LinkedList<>();

    static class Tree{
        int row;
        int col;
        int age;
        boolean dead;

        public Tree(int row, int col, int age) {
            this.row = row;
            this.col = col;
            this.age = age;
            dead = false;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        food = new int[n + 1][n + 1];
        map = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                // 겨울에 줄 양분
                map[i][j] = Integer.parseInt(st.nextToken());
                //초기 양분값 세팅
                food[i][j] = 5;
            }
        }

        // 나무 입력
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            treeList.add(new Tree(row, col, age));
        }

        Collections.sort(treeList, (t1, t2) -> t1.age - t2.age);

        // 1년 마다 해당 과정을 수행한다
        while(k != 0){
            spring();
            summer();
            fall();
            winter();
            // 1년 끝
            k--;
        }

        System.out.println(treeList.size());
    }
    /**
     * 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다. 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다.
     * 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
     * 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
     */
    public static void spring() {
        for (int i = 0; i < treeList.size(); i++) {
            Tree tree = treeList.get(i);
            // 땅의 양분이 나무의 나이보다 적으면
            if (food[tree.row][tree.col] < tree.age) {
                // 나무는 죽음
                deathTreeIndex.add(i);
                continue;
            }
            // 아니라면 땅의 양분 먹고 나무 나이 1증가
            food[tree.row][tree.col] -= tree.age;
            tree.age++;
        }
    }

    /**
     * 여름에는 봄에 죽은 나무가 양분으로 변하게 된다.
     * 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는 버린다.
     */
    static void summer(){
        while(!deathTreeIndex.isEmpty()){
            int treeIndex = deathTreeIndex.poll();
            Tree tree = treeList.get(treeIndex);
            food[tree.row][tree.col] += (tree.age / 2);
            tree.dead = true;
        }
    }

    /**
     *가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며,
     * 인접한 8개의 칸에 나이가 1인 나무가 생긴다. 어떤 칸 (r, c)와
     * 인접한 칸은 (r-1, c-1), (r-1, c), (r-1, c+1), (r, c-1), (r, c+1), (r+1, c-1), (r+1, c), (r+1, c+1) 이다.
     * 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
     */
    static void fall(){
        int[] moveRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] moveCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        ArrayList<Tree> newTreeList = new ArrayList<>();

        for(int i = 0; i < treeList.size(); i++){
            Tree tree = treeList.get(i);
            if(tree.dead){
                continue;
            }
            // 5살 이상이면 번식함
            if(tree.age % 5 == 0){
                for(int j = 0; j < moveRow.length; j++){
                    // 범위를 벗어나지 않으면 8개 방향으로 나무가 번식함
                    int nr = tree.row + moveRow[j];
                    int nc = tree.col + moveCol[j];

                    if (nr < 1 || nr >= n + 1 || nc < 1 || nc >= n + 1) {
                        continue;
                    }

                    newTreeList.add(new Tree(nr, nc, 1));
                }
            }
        }

        // 기존 살아있는 나무를 추가하자
        for(Tree tree : treeList){
            if(!tree.dead){
                newTreeList.add(tree);
            }
        }
        treeList = newTreeList;
    }

    /**
     * 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
     */

    static void winter(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                food[i][j] += map[i][j];
            }
        }
    }
}

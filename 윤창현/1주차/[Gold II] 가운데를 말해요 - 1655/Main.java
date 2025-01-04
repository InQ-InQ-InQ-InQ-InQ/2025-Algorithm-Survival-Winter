import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br;

    // 지워도 되는 변수들
    static PriorityQueue<Integer> leftHeap;
    static PriorityQueue<Integer> rightHeap;

    static int n;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        leftHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        rightHeap = new PriorityQueue<>();

        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

            // 일단 숫자를 넣어두고 생각하자
            // 사이즈가 같은 경우에만 left에 집어넣고, 다른 경우에는 right에 집어넣는다.
            // 즉 왼쪽 오른쪽 사이즈가 같도록 배치한다.
            if(leftHeap.size() == rightHeap.size()) leftHeap.offer(temp);
            else rightHeap.offer(temp);

            // DEBUG
            // printHeap(leftHeap, rightHeap);

            // 근데 만약 왼쪽 top값이 오른쪽 top값보다 작은 경우
            // 두 값을 swap하자
            // 이러고 왼쪽 heap의 최대값을 출력하면 해결하지 않을까?
            // [5 8] [10 3] -> [3 5] [8 10]
            if(!leftHeap.isEmpty() && !rightHeap.isEmpty()){
                if(leftHeap.peek() > rightHeap.peek()){
                    int swap = leftHeap.poll();
                    leftHeap.offer(rightHeap.poll());
                    rightHeap.offer(swap);
                }
            }

            sb.append(leftHeap.peek() + "\n");
        }

        System.out.println(sb);
    }

//    DEBUG
//    static void printHeap(PriorityQueue<Integer> q1, PriorityQueue<Integer> q2){
//        StringBuilder sb = new StringBuilder();
//
//        System.out.print("현재 heap의 상태 : ");
//        sb.append("[ ");
//        for(Integer num : q1){
//            sb.append(num).append(" ");
//        }
//        sb.append("]");
//        sb.append(" [ ");
//        for(Integer num : q2){
//            sb.append(num).append(" ");
//        }
//        sb.append("]\n");
//        System.out.print(sb + "\n");
//    }
}
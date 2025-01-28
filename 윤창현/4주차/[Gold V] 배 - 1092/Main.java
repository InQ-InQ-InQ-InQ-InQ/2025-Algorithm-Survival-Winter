import java.io.*;
import java.util.*;

public class Main {
    // 지우지 말것 -> 자주 쓰임
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 풀이용 변수
    static int n;
    static List<Integer> cranes;
    static int m;
    static List<Integer> boxes;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        cranes = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        // 오름차순으로 가장 무거운 박스와 무게 제한이 가장 높은 박스로 정렬
        cranes.sort(Comparator.reverseOrder());
        boxes.sort(Comparator.reverseOrder());

        int result = -1;

        // 만약 가장 무거운 것을 들 수 있는 크레인이 가장 무거운 박스를 못 드는 경우
        if(boxes.get(0) > cranes.get(0)){
            System.out.println(result);
            return;
        }

        // 박스를 모두 옮길 때까지 루프 진행
        result = 0;
        while(!boxes.isEmpty()) {
            int craneIndex = 0;
            int boxIndex = 0;

            while(craneIndex < n){
                // 모든 짐을 다 실은 경우
                if(boxIndex == boxes.size()){
                    break;
                }
                // 크레인에 짐을 실을 수 있는 경우
                else if(boxes.get(boxIndex) <= cranes.get(craneIndex)){
                    boxes.remove(boxIndex);
                    craneIndex++;
                }else{
                    // 박스를 실을 수 없는 경우 다음 박스를 끄집어낸다.
                    boxIndex++;
                }
            }

            // 이런 과정을 거치면 1분이 지남.
            result++;
        }

        System.out.println(result);
    }
}
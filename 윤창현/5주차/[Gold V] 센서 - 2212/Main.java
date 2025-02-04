import java.io.*;
import java.util.*;

public class Main {
    // 이건 지우는거 아님
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 사용 변수
    static int n;
    static int k;
    static int[] sensor;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        if(n <= k){
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        sensor = new int[n];
        for(int i = 0; i < n; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        // 가장 촘촘하게 기지국을 배치하자
        // 센서 위에 배치를 하되
        // 센서 사이의 거리가 작은곳 부터 우선적으로 배치하자

        Integer[] diff = new Integer[n - 1];
        for(int i = 0; i < n - 1; i++){
            diff[i] = sensor[i + 1] - sensor[i];
        }

        Arrays.sort(diff);

        // 주어진 테스트 케이스에서
        // sensor = [1 3 6 6 7 9]
        // diff =   [ 2 3 0 1 2 ]
        // 센서에 1개의 기지국을 단다고 생각하면
        // 센서가 n - k 개수 만큼의 센서를 커버 쳐야함


        int sum = 0;
        for(int i = 0; i < n - k; i++){
            sum += diff[i];
        }

        System.out.println(sum);
    }
}
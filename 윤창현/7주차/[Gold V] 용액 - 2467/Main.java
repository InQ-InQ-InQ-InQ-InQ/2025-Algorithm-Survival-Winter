import java.util.*;
import java.io.*;

public class Main {
    // 고정 변수들
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 변수들 지워도 됨
    static int n;
    static long[] arr;

    // 문제 풀이용 함수
    static void solveProblem() throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new long[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;

        int ml = 0;
        int mr = 0;
        long min = Long.MAX_VALUE;

        while(left < right) {
            long sum = arr[left] + arr[right];

            if(min > Math.abs(sum)) {
                min = Math.abs(sum);
                ml = left;
                mr = right;
            }

            if(sum >= 0){
                right--;
            }else{
                left++;
            }
        }

        System.out.println(arr[ml] + " " + arr[mr]);
    }


    public static void main(String[] args) throws IOException {
        solveProblem();
    }
}

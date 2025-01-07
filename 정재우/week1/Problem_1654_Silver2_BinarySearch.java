package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1654_Silver2_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] array = new int[k];
        for (int i = 0; i < k; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // k 개의 랜선 중 가장 짧은 랜선 길이 구하기
        long max = 0;
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        max++;

        // 이분 탐색 기준점 설정
        long start = 0;
        long mid = 0;
        long end = max;
        while (start < end) {
            mid = (start + end) / 2;

            // mid 값을 통해 만들 수 있는 랜선 개수 구하기
            long count = 0;
            for (int i : array) {
                count += i / mid;
            }

            // count 값이 k와 같은지 확인
            if (count < n) { // count 값이 n보다 작으면 랜선 길이를 줄여야 함
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end - 1);
    }
}

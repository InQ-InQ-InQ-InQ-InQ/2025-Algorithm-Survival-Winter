package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 도형은 정사각형으로 이루어져 있음
// 변의 길이는 무조건 2의 제곱 단위
// 모두 같은 색으로 칠해져 있지 않다면 -> 네 조각으로 나눈다.
// (잘라진 종이가 모두 단일 색으로 통일될 때까지 반복)

public class Problem_2630_Silver2_DivideAndConquer_Retry {
    static int N;
    static int[][] array;
    static int whiteCount, blueCount;

    public static void main(String[] args) throws IOException {
        // read
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // logic
        partition(0, 0, N);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    private static void partition(int row, int col, int size) {
        if (isAllColorSame(row, col, size)) {
            if (array[row][col] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
        } else {
            int dividedSize = size / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    partition(row + dividedSize * i, col + dividedSize * j, dividedSize);
                }
            }
        }
    }

    private static boolean isAllColorSame(int row, int col, int size) {
        int first = array[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (array[i][j] != first) {
                    return false;
                }
            }
        }

        return true;
    }
}

package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 도형은 정사각형으로 이루어져 있음
// 변의 길이는 무조건 2의 제곱 단위
// 모두 같은 색으로 칠해져 있지 않다면 -> 네 조각으로 나눈다.
// (잘라진 종이가 모두 단일 색으로 통일될 때까지 반복)

public class Problem_2630_Silver2_DivideAndConquer {
    static int N;
    static int[][] map;
    static int whiteCount, blueCount;

    public static void main(String[] args) throws IOException {
        // read
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // logic
        if (hasDifferentColor(map)) {
            divideAndCheck(map);
        } else {
            addCount(map);
        }

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    public static void divideAndCheck(int[][] map) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int[][] dividedMap = extractSubArray(map,
                        i * (map.length / 2),
                        (i + 1) * (map.length / 2),
                        j * (map.length / 2),
                        (j + 1) * (map.length / 2)
                );

                if (!hasDifferentColor(dividedMap)) {
                    addCount(dividedMap);
                } else {
                    divideAndCheck(dividedMap);
                }
            }
        }
    }

    // 특정 영역을 추출하는 메서드
    public static int[][] extractSubArray(int[][] array, int rowStart, int rowEnd, int colStart, int colEnd) {
        int[][] result = new int[rowEnd - rowStart][colEnd - colStart];
        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                result[i - rowStart][j - colStart] = array[i][j];
            }
        }
        return result;
    }

    public static boolean hasDifferentColor(int[][] map) {
        int start = map[0][0];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] != start) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void addCount(int[][] map) {
        int start = map[0][0];

        if (start == 0) {
            whiteCount ++;
        } else {
            blueCount ++;
        }
    }
}

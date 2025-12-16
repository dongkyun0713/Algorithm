package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
    static int N, M;
    static int[][] tomatoes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        int max = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0];
            int c = cur[1];
            int day = cur[2];

            if (day > max) {
                max = day;
            }

            // 아래
            if (r > 0 && tomatoes[r - 1][c] == 0) {
                tomatoes[r - 1][c] = 1;
                queue.add(new int[]{r - 1, c, day + 1});
            }

            // 왼쪽
            if (c > 0 && tomatoes[r][c - 1] == 0) {
                tomatoes[r][c - 1] = 1;
                queue.add(new int[]{r, c - 1, day + 1});
            }

            // 위
            if (r < N - 1 && tomatoes[r + 1][c] == 0) {
                tomatoes[r + 1][c] = 1;
                queue.add(new int[]{r + 1, c, day + 1});

            }

            // 오른쪽
            if (c < M - 1 && tomatoes[r][c + 1] == 0) {
                tomatoes[r][c + 1] = 1;
                queue.add(new int[]{r, c + 1, day + 1});

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 0) {
                    return -1;
                }
            }
        }
        return max;
    }
}

package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7569 {
    static int[][][] tomatoes;
    static int M, N, H;
    // 상, 우, 하, 좌
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoes[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k, 0});
                    }
                }
            }
        }
        int max = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int h = cur[0];
            int r = cur[1];
            int c = cur[2];
            int day = cur[3];
            max = Math.max(max, day);

            // 아래
            if (h > 0 && tomatoes[h - 1][r][c] == 0) {
                tomatoes[h - 1][r][c] = 1;
                queue.add(new int[]{h - 1, r, c, day + 1});
            }

            // 위
            if (h < H - 1 && tomatoes[h + 1][r][c] == 0) {
                tomatoes[h + 1][r][c] = 1;
                queue.add(new int[]{h + 1, r, c, day + 1});
            }
            // 상, 우, 하, 좌
            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];

                if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < M && tomatoes[h][nextR][nextC] == 0) {
                    tomatoes[h][nextR][nextC] = 1;
                    queue.add(new int[]{h, nextR, nextC, day + 1});
                }
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }
        return max;
    }
}

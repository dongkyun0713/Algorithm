package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14499 {
    static int N, M, x, y, k;
    static int[][] map;
    static int[] orders;
    static int[] dice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        orders = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }

        int curX = x;
        int curY = y;
        StringBuilder sb = new StringBuilder();

        // 동서북남
        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};

        // 0 top
        // 1 north
        // 2 south
        // 3 east
        // 4 west
        // 5 bottom
        dice = new int[6];

        for (int i = 0; i < k; i++) {
            int order = orders[i];

            int nx = curX + dx[order];
            int ny = curY + dy[order];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (order == 1) rollEast();
            else if (order == 2) rollWest();
            else if (order == 3) rollNorth();
            else rollSouth();
            if (map[nx][ny] == 0) {
               map[nx][ny] = dice[5];
            } else {
                dice[5] = map[nx][ny];
                map[nx][ny] = 0;
            }
            curX = nx;
            curY = ny;

            sb.append(dice[0]).append("\n");
        }
        System.out.print(sb);
    }
    private static void rollEast() {
        int temp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[5];
        dice[5] = dice[3];
        dice[3] = temp;
    }
    private static void rollWest() {
        int temp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[5];
        dice[5] = dice[4];
        dice[4] = temp;
    }

    private static void rollNorth() {
        int temp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[5];
        dice[5] = dice[1];
        dice[1] = temp;
    }

    private static void rollSouth() {
        int temp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[5];
        dice[5] = dice[2];
        dice[2] = temp;
    }
}


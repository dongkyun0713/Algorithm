package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 0: 북, 1: 동, 2: 남, 3: 서
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int count = 0;
        while (true) {
            if (map[r][c] == 0) {
                map[r][c] = 2;
                ++count;
            }
            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;          // 반시계 회전
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (map[nr][nc] == 0) {   // 청소 안 된 빈칸이면 전진
                    r = nr;
                    c = nc;
                    moved = true;
                    break;
                }
            }
            if (moved) {
                continue;
            }

            int back = (d + 2) % 4;  // 반대
            int backR = r + dr[back];
            int backC = c + dc[back];

            if (map[backR][backC] == 1) {
                break;
            }
            r = backR;
            c = backC;
        }

        System.out.println(count);
    }
}

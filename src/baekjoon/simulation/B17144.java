package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] room = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 상, 우, 하, 좌
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int t = 0; t < T; t++) {
            int[][] add = new int[R][C];

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    int box = room[r][c];
                    if (box >= 5) {
                        int a = box / 5;
                        int count = 0;
                        for (int i = 0; i < 4; i++) {
                            int nr = r + dr[i];
                            int nc = c + dc[i];
                            if (nr < 0 || nc < 0 || nr >= R || nc >= C || room[nr][nc] == -1) {
                                continue;
                            }
                            ++count;
                            add[nr][nc] += a;
                        }
                        room[r][c] -= a * count;
                    }
                }
            }
            int upR = -1, downR = -1;
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (room[r][c] == -1) {
                        if (upR == -1) {
                            upR = r;
                        } else {
                            downR = r;
                        }
                        continue;
                    }
                    room[r][c] += add[r][c];
                }
            }

            for (int r = upR-1; r > 0; r--) {
                room[r][0] = room[r - 1][0];
            }
            for (int c = 0; c < C - 1; c++) {
                room[0][c] = room[0][c + 1];
            }

            for (int r = 0; r < upR; r++) {
                room[r][C - 1] = room[r + 1][C - 1];
            }
            for (int c = C - 1; c > 1; c--) {
                room[upR][c] = room[upR][c - 1];
            }
            room[upR][1] = 0;


            for (int r = downR + 1; r < R - 1; r++) {
                room[r][0] = room[r + 1][0];
            }

            for (int c = 0; c < C - 1; c++) {
                room[R - 1][c] = room[R - 1][c + 1];
            }

            for (int r = R-1; r > downR; r--) {
                room[r][C-1] = room[r-1][C-1];
            }

            for (int c = C-1; c >1 ; c--) {
                room[downR][c] = room[downR][c - 1];
            }
            room[downR][1] = 0;

            room[upR][0] = -1;
            room[downR][0] = -1;
        }
        int answer = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                answer += room[r][c];
            }
        }
        System.out.println(answer + 2);
    }

}

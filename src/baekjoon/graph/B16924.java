package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B16924 {
    static int N, M;
    static char[][] arr;
    static boolean[][] visited;

    static class Cross {
        int r, c, s;

        Cross(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        List<Cross> ans = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] != '*') {
                    continue;
                }

                int size = 0;
                while (true) {
                    int ns = size + 1;
                    boolean ok = true;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d] * ns;
                        int nc = c + dc[d] * ns;

                        // 범위 체크 먼저
                        if (nr < 0 || nc < 0 || nr >= N || nc >= M || arr[nr][nc] != '*') {
                            ok = false;
                            break;
                        }
                    }

                    if (!ok) {
                        break;
                    }
                    size++;
                }

                if (size > 0) {
                    ans.add(new Cross(r, c, size));
                    visited[r][c] = true;
                    for (int s = 1; s <= size; s++) {
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d] * s;
                            int nc = c + dc[d] * s;
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] == '*' && !visited[r][c]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for (Cross x : ans) {
            sb.append(x.r + 1).append(' ')
                    .append(x.c + 1).append(' ')
                    .append(x.s).append('\n');
        }
        System.out.print(sb);
    }
}

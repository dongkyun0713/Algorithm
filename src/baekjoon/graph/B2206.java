package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2206 {
    static int N, M;
    static int[][] map;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1, 0});
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            int broken = cur[3];

            if (r == N - 1 && c == M - 1) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                if (map[nr][nc] == 0) {
                    if (!visited[nr][nc][broken]) {
                        visited[nr][nc][broken] = true;
                        queue.add(new int[]{nr, nc, d + 1, broken});
                    }
                } else {
                    if (broken == 0 && !visited[nr][nc][broken + 1]) {
                        visited[nr][nc][broken+1] = true;
                        queue.add(new int[]{nr, nc, d + 1, broken+1});
                    }
                }
            }
        }
        return -1;
    }

}

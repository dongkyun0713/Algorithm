package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17458 {
    static int N, M;
    static int[][] graph;
    static int[] dr = {-1, -1, -1};
    static int[] dc = {-1, 0, 1};
    static int[][][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        memo = new int[N][M][4];
        for (int r = 0; r < N; r++){
            for (int c = 0; c < M; c++) {
                Arrays.fill(memo[r][c], -1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            min = Math.min(min, dfs(N-1, i, 3));
        }
        System.out.println(min);
    }
    private static int dfs(int r, int c, int priorDir) {
        if (r == 0) return graph[r][c];
        if (memo[r][c][priorDir] != -1) {
            return memo[r][c][priorDir];
        }
        int best = Integer.MAX_VALUE;
        for (int d = 0; d < 3; d++) {
            if (d == priorDir) continue;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
            best = Math.min(best, dfs(nr, nc, d));
        }
        return memo[r][c][priorDir] = best + graph[r][c];
    }

}

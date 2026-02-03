package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14500 {
    static int N, M;
    static int[][] paper;
    static boolean[][] visited;
    // 상, 우, 하, 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                visited[r][c] = true;
                dfs(r, c, 1, paper[r][c]);
                visited[r][c] = false;

                checkT(r, c);
            }
        }
        System.out.println(max);
    }

    private static void dfs(int r, int c, int count, int sum) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M || visited[nextR][nextC]) continue;

            visited[nextR][nextC] = true;
            dfs(nextR, nextC, count + 1, sum + paper[nextR][nextC]);
            visited[nextR][nextC] = false;
        }
    }

    private static void checkT(int r, int c) {
        int sum = paper[r][c];
        int count = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (nextR < 0 || nextC < 0 || nextR >= N || nextC >= M) continue;


            count++;
            sum += paper[nextR][nextC];
            min = Math.min(min, paper[nextR][nextC]);
        }

        if (count == 3) {
            max = Math.max(max, sum);
        } else if (count == 4) {
            max = Math.max(max, sum - min);
        }
    }
}

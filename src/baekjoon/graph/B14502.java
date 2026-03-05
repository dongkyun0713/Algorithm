package baekjoon.graph;

import java.io.*;
import java.util.*;

public class B14502 {

    static int N, M;
    static int[][] graph;
    static List<int[]> virus = new ArrayList<>();

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

                if (graph[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int depth) {

        if (depth == 3) {
            answer = Math.max(answer, bfs());
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (graph[i][j] == 0) {

                    graph[i][j] = 1;

                    dfs(depth + 1);

                    graph[i][j] = 0;
                }
            }
        }
    }

    static int bfs() {

        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            temp[i] = graph[i].clone();
        }

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int[] v : virus) {
            q.add(new int[]{v[0], v[1]});
        }

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }
                if (temp[nr][nc] == 0) {
                    temp[nr][nc] = 2;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    safe++;
                }
            }
        }

        return safe;
    }
}
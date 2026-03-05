package baekjoon.ds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1189 {
    static int R, C, K;
    static char[][] graph;
    static boolean[][] visited;
    // 상우하좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, int dist) {
        if (dist == K) {
            if (r == 0 && c == C - 1) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc] || graph[nr][nc] == 'T') {
                continue;
            }
            visited[nr][nc] = true;
            dfs(nr, nc, dist + 1);
            visited[nr][nc] = false;
        }
    }
}

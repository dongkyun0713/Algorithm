package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class B1941 {
    static char[][] seating;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int answer = 0;
    static boolean[] totalVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        seating = new char[5][5];
        for (int i = 0; i < 5; i++) {
            seating[i] = br.readLine().toCharArray();
        }
        visited = new boolean[5][5];
        totalVisited = new boolean[25];
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int idx, int yCount) {
        if (yCount >= 4) {
            return;
        }
        if (depth == 7) {
            int cur = idx - 1;
            if (bfs(cur / 5, cur % 5)) {
                answer++;
            }
            return;
        }

        for (int i = idx; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            totalVisited[i] = true;
            if (seating[r][c] == 'Y') {
                dfs(depth + 1, i + 1, yCount + 1);
            } else {
                dfs(depth + 1, i + 1, yCount);
            }
            totalVisited[i] = false;
        }
    }

    static boolean bfs(int r, int c) {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int cr = cur[0];
            int cc = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || visited[nr][nc] || !totalVisited[nr * 5 + nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
                cnt++;
            }
        }
        return cnt == 7;
    }
}

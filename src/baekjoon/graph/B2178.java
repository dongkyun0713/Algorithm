package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {
    static int N, M;
    static char[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 1});
        while (!queue.isEmpty()) {
            int[] u = queue.remove();
            int r = u[0], c = u[1], distance = u[2];
            if (r == N -1 && c == M -1) {
                return distance;
            }
            if (maze[r][c] == '0') {
                continue;
            }
            if (visited[r][c]) {
                continue;
            }
            visited[r][c] = true;
            if (r > 0) {
                queue.add(new int[]{r - 1, c, distance + 1});
            }
            if (c > 0) {
                queue.add(new int[]{r, c-1, distance + 1});
            }
            if (r < N - 1) {
                queue.add(new int[]{r + 1, c, distance + 1});
            }
            if (c < M - 1) {
                queue.add(new int[]{r, c + 1, distance + 1});
            }
        }
        return -1;
    }
}

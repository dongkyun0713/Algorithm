package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class B2667_bfs {
    static int n;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    sizes.add(bfs(i, j));
                }
            }
        }
        Collections.sort(sizes);
        StringBuilder sb = new StringBuilder();
        sb.append(sizes.size()).append("\n");
        for (int i = 0; i < sizes.size(); i++) {
            sb.append(sizes.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int startRow, int startCol) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0];
            int c = cur[1];

            // 위
            if (r > 0 && !visited[r - 1][c] && map[r - 1][c] == '1') {
                visited[r - 1][c] = true;
                queue.add(new int[]{r - 1, c});
                ++count;
            }

            // 왼쪽
            if (c > 0 && !visited[r][c - 1] && map[r][c - 1] == '1') {
                visited[r][c - 1] = true;
                queue.add(new int[]{r, c - 1});
                ++count;
            }

            // 아래
            if (r < n - 1 && !visited[r + 1][c] && map[r + 1][c] == '1') {
                visited[r + 1][c] = true;
                queue.add(new int[]{r + 1, c});
                ++count;
            }

            // 오른쪽
            if (c < n - 1 && !visited[r][c + 1] && map[r][c + 1] == '1') {
                visited[r][c + 1] = true;
                queue.add(new int[]{r, c + 1});
                ++count;
            }
        }
        return count;
    }


}

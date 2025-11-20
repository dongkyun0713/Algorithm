package programmers.level_2;

import java.util.ArrayDeque;
import java.util.Queue;

public class P1844 {
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int ROW, COL;

    public int solution(int[][] maps) {
        ROW = maps.length;
        COL = maps[0].length;


        return bfs(maps);
    }

    public static int bfs(int[][] maps) {
        visited = new boolean[ROW][COL];
        queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});  // 출발 좌표

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int r = current[0];
            int c = current[1];
            int distance = current[2];

            if (visited[r][c] || maps[r][c] == 0) {
                continue;
            }

            visited[r][c] = true;

            if (r == ROW - 1 && c == COL - 1) {
                return distance;
            }
            if (r > 0) {  // 위쪽으로 갈 수 있을 때
                queue.add(new int[]{r - 1, c, distance + 1});
            }
            if (c > 0) { // 왼쪽으로 갈 수 있을 때
                queue.add(new int[]{r, c - 1, distance + 1});
            }
            if (r < ROW - 1) { // 아래쪽으로 갈 수 있을 때
                queue.add(new int[]{r + 1, c, distance + 1});
            }
            if (c < COL - 1) { // 오른쪽으로 갈 수 있을 때
                queue.add(new int[]{r, c + 1, distance + 1});
            }

        }
        return -1;
    }
}

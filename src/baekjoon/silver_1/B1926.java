package baekjoon.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1926 {
    static int N, M;
    static int[][] grid;
    static int size;

    private static void dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        size++;
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
    }

    private static List<Integer> sizeIsPaint(int[][] grid) {
        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    size = 0;
                    dfs(i, j, grid);
                    sizes.add(size);
                }
            }
        }
        return sizes;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> sizes = sizeIsPaint(grid);
        StringBuilder sb = new StringBuilder();
        int size = sizes.size();
        sb.append(size).append("\n");  // 그림 개수

        Collections.sort(sizes);
        if (size != 0) {
            Collections.sort(sizes);
            sb.append(sizes.get(size - 1));
        } else {
            sb.append(0);
        }
        System.out.println(sb);
    }
}

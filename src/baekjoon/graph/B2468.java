package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2468 {
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int max = 0;
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int h = Integer.parseInt(st.nextToken());
                max = Math.max(max, h);
                graph[i][j] = h;
            }
        }
        int answer = 0;
        for (int h = 0; h < max; h++) {
            int count = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] > h && !visited[i][j]) {
                        dfs(i, j, h);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    private static void dfs(int i, int j, int h) {
        if (i < 0 || i >= N || j < 0 || j >= N || graph[i][j] <= h || visited[i][j]) return;
        visited[i][j] = true;
        dfs(i + 1, j, h);
        dfs(i - 1, j, h);
        dfs(i, j + 1, h);
        dfs(i, j - 1, h);
    }
}

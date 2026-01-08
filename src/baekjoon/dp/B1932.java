package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1932 {
    static int[][] triangle;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        triangle = new int[n + 1][n + 1];
        memo = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        memo[1][1] = triangle[1][1];

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dfs(n, i));
        }

        System.out.println(answer);
    }

    private static int dfs(int r, int c) {
        if (c < 1 || c > r) {
            return 0;
        }

        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        return memo[r][c] = triangle[r][c] + Math.max(dfs(r - 1, c), dfs(r - 1, c - 1));
    }
}

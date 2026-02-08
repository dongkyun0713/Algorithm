package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2755 {
    static int T;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        memo = new int[15][16];
        for (int j = 1; j <= 15; j++) {
            memo[0][j] = j;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(dfs(k, n)).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int k, int n) {
        if (memo[k][n] != 0) {
            return memo[k][n];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dfs(k - 1, i);
        }
        return memo[k][n] = sum;
    }
}

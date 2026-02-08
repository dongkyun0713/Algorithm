package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1003 {
    static int T, N;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            memo = new int[N + 1][2];
            for (int j = 0; j <= N; j++) {
                Arrays.fill(memo[j], -1);
            }
            memo[0][0] = 1;
            memo[0][1] = 0;
            if (N > 0) {
                memo[1][0] = 0;
                memo[1][1] = 1;
            }
            sb.append(dfs(N, 0)).append(" ").append(dfs(N, 1)).append("\n");
        }
        System.out.print(sb);
    }


    private static int dfs(int n, int zeroOrOne) {
        if (memo[n][zeroOrOne] != -1) {
            return memo[n][zeroOrOne];
        }

        return memo[n][zeroOrOne] = dfs(n - 1, zeroOrOne) + dfs(n - 2, zeroOrOne);
    }
}

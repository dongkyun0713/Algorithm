package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2193 {
    static long[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new long[n + 1][2];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        memo[1][0] = 0;
        memo[1][1] = 1;

        System.out.println(dfs(n, 0) + dfs(n, 1));
    }

    private static long dfs(int n, int last) {
        if (memo[n][last] != -1) {
            return memo[n][last];
        }

        if (last == 0) {
            memo[n][0] = dfs(n - 1, 0) + dfs(n - 1, 1);
        } else {
            memo[n][1] = dfs(n -1, 0);
        }

        return memo[n][last];
    }
}

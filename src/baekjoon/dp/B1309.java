package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1309 {
    static int MOD = 9901;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        memo = new int[n + 1][3]; // 0: X , 1: 왼쪽, 2: 오른쪽

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }

        memo[1][0] = 1;
        memo[1][1] = 1;
        memo[1][2] = 1;

        System.out.println((dfs(n, 0) + dfs(n, 1) + dfs(n, 2)) % MOD);
    }

    private static int dfs(int n, int state) {
        if (memo[n][state] != -1) {
            return memo[n][state];
        }

        if (state == 0) {
            memo[n][state] = dfs(n - 1, 0) + dfs(n - 1, 1) + dfs(n - 1, 2);
        } else if (state == 1) {
            memo[n][state] = dfs(n - 1, 0) + dfs(n - 1, 2);
        } else {
            memo[n][state] = dfs(n - 1, 0) + dfs(n - 1, 1);
        }

        return memo[n][state] % MOD;
    }
}

package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1699 {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];

        System.out.println(dfs(n));
    }

    private static int dfs(int n) {
        if (n == 0) return 0;

        if (memo[n] != 0) {
            return memo[n];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
           min = Math.min(min, dfs(n - (i * i)));
        }

        return memo[n] = min + 1;
    }
}

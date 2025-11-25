package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579 {
    static int[] memo;
    static int[] stair;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 10];
        stair = new int[n + 10];

        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        memo[1] = stair[1];
        memo[2] = stair[1] + stair[2];

        System.out.println(dfs(n));

    }

    private static int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (memo[n] != 0) {
            return memo[n];
        }

        int result = Math.max(dfs(n-2) + stair[n], dfs(n-3) + stair[n-1] + stair[n]);
        return memo[n] = result;
    }
}

package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463 {
    static int[] memo;
    static int MAX = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];
        System.out.println(dfs(n));
    }

    private static int dfs(int x) {
        if (x == 1) {
            return 0;
        }
        if (memo[x] != 0) {
            return memo[x];
        }

        int a = MAX;
        int b = MAX;

        if (x % 3 == 0) {
            a = dfs(x / 3);
        }

        if (x % 2 == 0) {
            b = dfs(x / 2);
        }

        int c = dfs(x - 1);

        return Math.min(a, Math.min(b, c)) + 1;
    }
}

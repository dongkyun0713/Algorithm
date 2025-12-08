package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11057 {
    static int n;
    static int[][] memo;
    static int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new int[n + 1][10];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dfs(n, i);
            answer %= MOD;
        }
        System.out.println(answer);
    }

    private static int dfs(int len, int last) {
        if (len == 1) {
            return 1;
        }
        if (memo[len][last] != -1) {
            return memo[len][last];
        }

        int result = 0;

        for (int i = 0; i <= last; i++) {
            result += dfs(len - 1, i);
        }
        return memo[len][last] = result % MOD;
    }
}

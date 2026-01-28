package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2225 {
    static int[][] memo;
    static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        memo = new int[N+1][K+1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], -1);
        }

        System.out.println(dfs(N, K) % MOD);
    }

    private static int dfs(int n, int k) {
        if (n < 0 || k <= 0) return 0;

        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        if (k == 1) return 1;

        return memo[n][k] = (dfs(n - 1, k) + dfs(n, k - 1)) % MOD;
    }
}

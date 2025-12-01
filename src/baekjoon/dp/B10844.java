package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10844 {
    static long[][] memo;
    static int n;
    static final long MOD = 1_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        memo = new long[n + 1][10];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }

        long answer = 0;
        for (int i = 1; i <= 9; i++) {
            answer = (answer + dfs(1, i)) % MOD;
        }
        System.out.println(answer);
    }

    private static long dfs(int pos, int last) {
         if (pos == n) {
            return 1;
        }

         if (memo[pos][last] != -1) {
             return memo[pos][last];
         }

         long result = 0;

         if (last - 1 >= 0) {
             result += dfs(pos + 1, last - 1);
         }

         if (last + 1 <= 9) {
             result += dfs(pos + 1, last + 1);
         }

         return memo[pos][last] = result % MOD;
    }
}

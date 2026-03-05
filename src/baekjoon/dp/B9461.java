package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B9461 {
    static long[] memo;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        memo = new long[101];
        Arrays.fill(memo, -1);
        memo[1] = memo[2] = memo[3] = 1;

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb.append(dfs(N)).append("\n");
        }

        System.out.print(sb);
    }

    private static long dfs(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }

        return memo[n] = dfs(n-2) + dfs(n-3);
    }
}

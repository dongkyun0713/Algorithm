package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11722 {
    static int n;
    static int[] seq;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        memo = new int[n][1000 + 10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
            seq[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(0, 1000 + 1));
    }

    private static int dfs(int k, int prev) {
        if (k == n) {
            return 0;
        }

        if (memo[k][prev] != -1) {
            return memo[k][prev];
        }

        int a = (seq[k] < prev) ? dfs(k + 1, seq[k]) + 1 : 0;
        int b = dfs(k + 1, prev);

        return memo[k][prev] = Math.max(a, b);
    }
}

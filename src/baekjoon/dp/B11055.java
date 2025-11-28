package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11055 {
    static int n;
    static int[] seq;
    static int[][] memo;
    static int maxSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        seq = new int[n];
        memo = new int[n][1000 + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        System.out.println(dfs(0, 0));
    }

    private static int dfs(int t, int prev) {
        if (t == n) {
            return 0;
        }

        if (memo[t][prev] != -1) {
            return memo[t][prev];
        }

        int a = (seq[t] > prev) ? dfs(t + 1, seq[t]) + seq[t] : 0;
        int b = dfs(t + 1, prev);

        return memo[t][prev] = Math.max(a, b);
    }
}

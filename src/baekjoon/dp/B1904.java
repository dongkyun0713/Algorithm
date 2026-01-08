package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1904 {
    static int MAX = 15746;
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        memo = new int[N + 1];

        Arrays.fill(memo, -1);
        memo[1] = 1;
        if (N >= 2) {
            memo[2] = 2;
        }

        System.out.println(dfs(N));
    }

    private static int dfs(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }

        return memo[n] = (dfs(n-1) + dfs(n-2)) % MAX;
    }
}

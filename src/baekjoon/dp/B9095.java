package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9095 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        memo = new int[12];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dfs(n)).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = dfs(n - 1) + dfs(n - 2) + dfs(n - 3);
    }
}

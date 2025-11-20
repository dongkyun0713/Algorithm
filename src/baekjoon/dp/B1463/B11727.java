package baekjoon.dp.B1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11727 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        System.out.println(dfs(n));
    }

    private static int dfs(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }

        return memo[n] = (dfs(n - 1) + dfs(n - 2) + dfs(n - 2)) % 10007;
    }
}

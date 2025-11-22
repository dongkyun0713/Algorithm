package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2133 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 10];
        memo[0] = 1;
        memo[2] = 3;

        if (n % 2 != 0) {
            System.out.println(0);
        } else {
            System.out.println(dfs(n));
        }
    }

    private static int dfs(int n) {
       if (memo[n] != 0) {
           return memo[n];
       }

        int result = 3 * dfs(n - 2);

        for (int i = 4; i <= n; i += 2) {
            result += 2 * dfs(n - i);
        }

        return memo[n] = result;
    }
}
